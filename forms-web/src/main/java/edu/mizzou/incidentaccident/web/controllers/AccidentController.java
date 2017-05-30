package edu.mizzou.incidentaccident.web.controllers;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mizzou.incidentaccident.api.common.util.SigGen;
import edu.mizzou.incidentaccident.api.common.util.SignatureToImage;
import edu.mizzou.incidentaccident.api.models.AccidentModel;
import edu.mizzou.incidentaccident.api.models.EmailModel;
import edu.mizzou.incidentaccident.api.models.InjuryLocationsModel;
import edu.mizzou.incidentaccident.api.models.SignatureModel;
import edu.mizzou.incidentaccident.api.services.AccidentDetailDescriptionService;
import edu.mizzou.incidentaccident.api.services.AccidentService;
import edu.mizzou.incidentaccident.api.services.InjuryLocationsService;
import edu.mizzou.incidentaccident.api.services.LocationsService;
import edu.mizzou.incidentaccident.web.models.AccidentSearchForm;
import edu.mizzou.incidentaccident.web.validators.AccidentValidator;
import edu.mizzou.incidentaccident.api.common.util.EmailUtil;
import edu.mizzou.incidentaccident.api.services.EmailService;
import edu.mizzou.incidentaccident.api.services.UsersService;

@Controller
@RequestMapping(value="/accident")
public class AccidentController {

	@Autowired
	AccidentService accidentService;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	LocationsService locationsService;

	@Autowired
	InjuryLocationsService injuryLocationsService;
	
	@Autowired
	AccidentDetailDescriptionService accidentDetailDescriptionService;
	
	@Autowired
	AccidentValidator accidentValidator;
	
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createAccidentForm(ModelMap map) {
		map.addAttribute("accidentForm", new AccidentModel());
		map.addAttribute("locationsMap", locationsService.getLocations());
		map.addAttribute("injuryLocationsMap", injuryLocationsService.getInjuryLocations());
		map.addAttribute("accidentDetailDesc", accidentDetailDescriptionService.getAccidentDetailDescriptionList());
		return "accident.create";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String saveAccidentForm(@ModelAttribute("accidentForm") AccidentModel accident, BindingResult result, ModelMap map, HttpServletRequest request) {
		setInjuryLocationsWithOutSubs(accident);
		accidentValidator.validate(accident, result);
		if (result.hasErrors()) {
			map.addAttribute("errMsg", "Please fix belows errors before submitting.");
			map.addAttribute("accidentForm", accident);
			map.addAttribute("locationsMap", locationsService.getLocations());
			map.addAttribute("injuryLocationsMap", injuryLocationsService.getInjuryLocations());
			map.addAttribute("accidentDetailDesc", accidentDetailDescriptionService.getAccidentDetailDescriptionList());
			return "accident.create";
		} else {
			accident.setCreatedBy(request.getUserPrincipal().getName());
			accidentService.addAccident(accident);
			EmailUtil emailer = new EmailUtil();
			if(accident.getProgramActivity().isClubRecSports()) {
				List<EmailModel> list = emailService.getEmailList("clubsports");
				String emailList = "";
				for(int i = 0; i < list.size() - 1; i++) {
					emailList += usersService.getUserEmailAddress(list.get(i).getUserId());
					emailList += ",";
				}
				emailList += usersService.getUserEmailAddress(list.get(list.size() - 1).getUserId());
				
				emailer.sendEmail(emailList);
				
			}
			if(accident.getProgramActivity().isInformalActivity()) {
				List<EmailModel> list = emailService.getEmailList("facilities");
				String emailList = "";
				for(int i = 0; i < list.size() - 1; i++) {
					emailList += usersService.getUserEmailAddress(list.get(i).getUserId());
					emailList += ",";
				}
				emailList += usersService.getUserEmailAddress(list.get(list.size() - 1).getUserId());
				
				emailer.sendEmail(emailList);
				
			}
			return "redirect:/accident/list";
		}
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editAccidentForm(@PathVariable String id, ModelMap map) {
		map.addAttribute("accidentForm", accidentService.getAccident(new Integer(id)));
		map.addAttribute("locationsMap", locationsService.getLocations());
		map.addAttribute("injuryLocationsMap", injuryLocationsService.getInjuryLocations());
		map.addAttribute("accidentDetailDesc", accidentDetailDescriptionService.getAccidentDetailDescriptionList());
		return "accident.edit";
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteAccident(@PathVariable String id, ModelMap map) {
		accidentService.deleteAccident(new Integer(id));
		return "redirect:/accident/list";
	}

	@RequestMapping(value="/deleteMult", method=RequestMethod.GET)
	public String deleteAccidents(@RequestParam("id") String[] ids, ModelMap map) {
		for (int i = 0; i < ids.length; i++) {
			accidentService.deleteAccident(new Integer(ids[i]));
		}
		return "redirect:/accident/list";
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String changeAccidentForm(@ModelAttribute("accidentForm") AccidentModel accident, BindingResult result, ModelMap map, HttpServletRequest request) {
		setInjuryLocationsWithOutSubs(accident);
		accidentValidator.validate(accident, result);
		if (result.hasErrors()) {
			map.addAttribute("errMsg", "Please fix belows errors before submitting.");
			map.addAttribute("accidentForm", accident);
			map.addAttribute("locationsMap", locationsService.getLocations());
			map.addAttribute("injuryLocationsMap", injuryLocationsService.getInjuryLocations());
			map.addAttribute("accidentDetailDesc", accidentDetailDescriptionService.getAccidentDetailDescriptionList());
			return "accident.edit";
		} else {
			accident.setModifiedBy(request.getUserPrincipal().getName());
			accidentService.updateAccident(accident);
			return "redirect:/accident/list";
		}
	}

	@RequestMapping(value="/approve/{id}", method=RequestMethod.GET)
	public String approveAccidentForm(@PathVariable String id, ModelMap map, HttpServletRequest request) {
		AccidentModel accident = accidentService.getAccident(new Integer(id));
		accidentService.approveAccidentReport(accident.getProperNotificationsId(), request.getUserPrincipal().getName());
		return "redirect:/accident/view/"+id;
	}

	@RequestMapping(value="/list")
	public String getAccidentList(ModelMap map) {
		map.addAttribute("accidents", accidentService.getAccidentList());
		map.addAttribute("accidentSearchForm", new AccidentSearchForm());
		map.addAttribute("checkAll","<input type=\"checkbox\" class=\"noPrint\" name=\"allbox\" onclick=\"check(this.checked);\" title=\"Select all\"/>");
		return "accident.list";
	}

	@RequestMapping(value="/view/{id}")
	public String displayAccidentReport(@PathVariable String id, ModelMap map) {
		map.addAttribute("accident", accidentService.getAccident(new Integer(id)));
		return "accident.view";
	}

	@RequestMapping(value="/genSig")
	public void generateSignatureImage(HttpServletResponse response) {
		String dataUrl = "[{'lx':17,'ly':11,'mx':17,'my':10},{'lx':17,'ly':11,'mx':17,'my':11},{'lx':18,'ly':12,'mx':17,'my':11},{'lx':18,'ly':13,'mx':18,'my':12},{'lx':18,'ly':14,'mx':18,'my':13},{'lx':18,'ly':16,'mx':18,'my':14},{'lx':18,'ly':17,'mx':18,'my':16},{'lx':18,'ly':18,'mx':18,'my':17},{'lx':18,'ly':19,'mx':18,'my':18},{'lx':18,'ly':20,'mx':18,'my':19},{'lx':17,'ly':22,'mx':18,'my':20},{'lx':17,'ly':23,'mx':17,'my':22},{'lx':17,'ly':24,'mx':17,'my':23},{'lx':17,'ly':25,'mx':17,'my':24},{'lx':17,'ly':23,'mx':17,'my':25},{'lx':16,'ly':22,'mx':17,'my':23},{'lx':16,'ly':21,'mx':16,'my':22},{'lx':16,'ly':18,'mx':16,'my':21},{'lx':16,'ly':17,'mx':16,'my':18},{'lx':17,'ly':16,'mx':16,'my':17},{'lx':17,'ly':14,'mx':17,'my':16},{'lx':17,'ly':12,'mx':17,'my':14},{'lx':17,'ly':10,'mx':17,'my':12},{'lx':17,'ly':8,'mx':17,'my':10},{'lx':17,'ly':5,'mx':17,'my':8},{'lx':17,'ly':4,'mx':17,'my':5},{'lx':17,'ly':2,'mx':17,'my':4},{'lx':17,'ly':1,'mx':17,'my':2},{'lx':17,'ly':2,'mx':17,'my':1},{'lx':17,'ly':3,'mx':17,'my':2},{'lx':17,'ly':7,'mx':17,'my':3},{'lx':17,'ly':9,'mx':17,'my':7},{'lx':17,'ly':11,'mx':17,'my':9},{'lx':17,'ly':13,'mx':17,'my':11},{'lx':17,'ly':14,'mx':17,'my':13},{'lx':17,'ly':15,'mx':17,'my':14},{'lx':17,'ly':16,'mx':17,'my':15},{'lx':17,'ly':17,'mx':17,'my':16},{'lx':18,'ly':18,'mx':17,'my':17},{'lx':18,'ly':19,'mx':18,'my':18},{'lx':18,'ly':17,'mx':18,'my':19},{'lx':18,'ly':15,'mx':18,'my':17},{'lx':19,'ly':12,'mx':18,'my':15},{'lx':20,'ly':11,'mx':19,'my':12},{'lx':20,'ly':10,'mx':20,'my':11},{'lx':20,'ly':8,'mx':20,'my':10},{'lx':21,'ly':7,'mx':20,'my':8},{'lx':23,'ly':5,'mx':21,'my':7},{'lx':23,'ly':4,'mx':23,'my':5},{'lx':23,'ly':3,'mx':23,'my':4},{'lx':24,'ly':3,'mx':23,'my':3},{'lx':25,'ly':3,'mx':24,'my':3},{'lx':25,'ly':2,'mx':25,'my':3},{'lx':26,'ly':3,'mx':25,'my':2},{'lx':28,'ly':4,'mx':26,'my':3},{'lx':28,'ly':5,'mx':28,'my':4},{'lx':31,'ly':6,'mx':28,'my':5},{'lx':32,'ly':7,'mx':31,'my':6},{'lx':32,'ly':8,'mx':32,'my':7},{'lx':33,'ly':11,'mx':32,'my':8},{'lx':33,'ly':13,'mx':33,'my':11},{'lx':34,'ly':14,'mx':33,'my':13},{'lx':34,'ly':16,'mx':34,'my':14},{'lx':34,'ly':18,'mx':34,'my':16},{'lx':35,'ly':21,'mx':34,'my':18},{'lx':35,'ly':22,'mx':35,'my':21},{'lx':35,'ly':23,'mx':35,'my':22},{'lx':35,'ly':24,'mx':35,'my':23},{'lx':35,'ly':25,'mx':35,'my':24},{'lx':34,'ly':22,'mx':35,'my':25},{'lx':33,'ly':21,'mx':34,'my':22},{'lx':33,'ly':18,'mx':33,'my':21},{'lx':33,'ly':17,'mx':33,'my':18},{'lx':33,'ly':15,'mx':33,'my':17},{'lx':32,'ly':12,'mx':33,'my':15},{'lx':32,'ly':10,'mx':32,'my':12},{'lx':32,'ly':9,'mx':32,'my':10},{'lx':32,'ly':8,'mx':32,'my':9},{'lx':32,'ly':7,'mx':32,'my':8},{'lx':32,'ly':6,'mx':32,'my':7},{'lx':32,'ly':8,'mx':32,'my':6},{'lx':32,'ly':10,'mx':32,'my':8},{'lx':31,'ly':11,'mx':32,'my':10},{'lx':31,'ly':12,'mx':31,'my':11},{'lx':31,'ly':13,'mx':31,'my':12},{'lx':31,'ly':14,'mx':31,'my':13},{'lx':33,'ly':14,'mx':31,'my':14},{'lx':36,'ly':12,'mx':33,'my':14},{'lx':42,'ly':9,'mx':36,'my':12},{'lx':48,'ly':7,'mx':42,'my':9},{'lx':54,'ly':5,'mx':48,'my':7},{'lx':60,'ly':4,'mx':54,'my':5},{'lx':65,'ly':4,'mx':60,'my':4},{'lx':71,'ly':2,'mx':65,'my':4},{'lx':72,'ly':3,'mx':71,'my':2},{'lx':72,'ly':5,'mx':72,'my':3},{'lx':72,'ly':8,'mx':72,'my':5},{'lx':72,'ly':10,'mx':72,'my':8},{'lx':72,'ly':12,'mx':72,'my':10},{'lx':72,'ly':15,'mx':72,'my':12},{'lx':72,'ly':16,'mx':72,'my':15},{'lx':71,'ly':18,'mx':72,'my':16},{'lx':71,'ly':20,'mx':71,'my':18},{'lx':70,'ly':22,'mx':71,'my':20},{'lx':70,'ly':23,'mx':70,'my':22},{'lx':69,'ly':24,'mx':70,'my':23},{'lx':68,'ly':25,'mx':69,'my':24},{'lx':67,'ly':25,'mx':68,'my':25},{'lx':64,'ly':23,'mx':67,'my':25},{'lx':63,'ly':22,'mx':64,'my':23},{'lx':62,'ly':21,'mx':63,'my':22},{'lx':61,'ly':20,'mx':62,'my':21},{'lx':61,'ly':18,'mx':61,'my':20},{'lx':59,'ly':17,'mx':61,'my':18},{'lx':58,'ly':16,'mx':59,'my':17},{'lx':57,'ly':16,'mx':58,'my':16},{'lx':56,'ly':16,'mx':57,'my':16},{'lx':55,'ly':16,'mx':56,'my':16},{'lx':54,'ly':16,'mx':55,'my':16},{'lx':53,'ly':17,'mx':54,'my':16},{'lx':51,'ly':17,'mx':53,'my':17},{'lx':50,'ly':18,'mx':51,'my':17},{'lx':50,'ly':19,'mx':50,'my':18},{'lx':49,'ly':20,'mx':50,'my':19},{'lx':49,'ly':21,'mx':49,'my':20},{'lx':48,'ly':23,'mx':49,'my':21},{'lx':48,'ly':24,'mx':48,'my':23},{'lx':48,'ly':26,'mx':48,'my':24},{'lx':48,'ly':27,'mx':48,'my':26},{'lx':51,'ly':27,'mx':48,'my':27},{'lx':61,'ly':25,'mx':51,'my':27},{'lx':72,'ly':23,'mx':61,'my':25},{'lx':81,'ly':22,'mx':72,'my':23},{'lx':90,'ly':19,'mx':81,'my':22},{'lx':96,'ly':19,'mx':90,'my':19},{'lx':98,'ly':17,'mx':96,'my':19},{'lx':99,'ly':16,'mx':98,'my':17},{'lx':97,'ly':17,'mx':99,'my':16},{'lx':95,'ly':17,'mx':97,'my':17},{'lx':94,'ly':17,'mx':95,'my':17},{'lx':93,'ly':17,'mx':94,'my':17},{'lx':94,'ly':17,'mx':93,'my':17},{'lx':94,'ly':16,'mx':94,'my':17},{'lx':96,'ly':15,'mx':94,'my':16},{'lx':98,'ly':14,'mx':96,'my':15},{'lx':99,'ly':13,'mx':98,'my':14},{'lx':101,'ly':13,'mx':99,'my':13},{'lx':102,'ly':12,'mx':101,'my':13},{'lx':104,'ly':12,'mx':102,'my':12},{'lx':105,'ly':12,'mx':104,'my':12},{'lx':106,'ly':12,'mx':105,'my':12},{'lx':107,'ly':12,'mx':106,'my':12},{'lx':108,'ly':11,'mx':107,'my':12},{'lx':109,'ly':12,'mx':108,'my':11},{'lx':109,'ly':13,'mx':109,'my':12},{'lx':110,'ly':13,'mx':109,'my':13},{'lx':110,'ly':14,'mx':110,'my':13},{'lx':111,'ly':14,'mx':110,'my':14},{'lx':112,'ly':15,'mx':111,'my':14},{'lx':113,'ly':15,'mx':112,'my':15},{'lx':113,'ly':16,'mx':113,'my':15},{'lx':114,'ly':16,'mx':113,'my':16},{'lx':115,'ly':16,'mx':114,'my':16},{'lx':116,'ly':17,'mx':115,'my':16},{'lx':117,'ly':18,'mx':116,'my':17},{'lx':118,'ly':18,'mx':117,'my':18},{'lx':119,'ly':18,'mx':118,'my':18},{'lx':121,'ly':18,'mx':119,'my':18},{'lx':122,'ly':18,'mx':121,'my':18},{'lx':125,'ly':18,'mx':122,'my':18},{'lx':126,'ly':18,'mx':125,'my':18},{'lx':129,'ly':17,'mx':126,'my':18},{'lx':130,'ly':17,'mx':129,'my':17},{'lx':131,'ly':16,'mx':130,'my':17},{'lx':132,'ly':16,'mx':131,'my':16},{'lx':133,'ly':14,'mx':132,'my':16},{'lx':133,'ly':13,'mx':133,'my':14},{'lx':133,'ly':12,'mx':133,'my':13},{'lx':132,'ly':12,'mx':133,'my':12},{'lx':131,'ly':12,'mx':132,'my':12},{'lx':130,'ly':12,'mx':131,'my':12},{'lx':129,'ly':11,'mx':130,'my':12},{'lx':126,'ly':9,'mx':129,'my':11},{'lx':122,'ly':9,'mx':126,'my':9},{'lx':117,'ly':8,'mx':122,'my':9},{'lx':109,'ly':8,'mx':117,'my':8},{'lx':101,'ly':8,'mx':109,'my':8},{'lx':95,'ly':8,'mx':101,'my':8},{'lx':91,'ly':8,'mx':95,'my':8},{'lx':87,'ly':10,'mx':91,'my':8},{'lx':86,'ly':10,'mx':87,'my':10},{'lx':86,'ly':11,'mx':86,'my':10},{'lx':85,'ly':11,'mx':86,'my':11},{'lx':85,'ly':13,'mx':85,'my':11},{'lx':85,'ly':14,'mx':85,'my':13},{'lx':85,'ly':15,'mx':85,'my':14},{'lx':85,'ly':16,'mx':85,'my':15},{'lx':86,'ly':18,'mx':85,'my':16},{'lx':90,'ly':18,'mx':86,'my':18},{'lx':105,'ly':18,'mx':90,'my':18},{'lx':109,'ly':18,'mx':105,'my':18},{'lx':114,'ly':16,'mx':109,'my':18},{'lx':117,'ly':15,'mx':114,'my':16},{'lx':121,'ly':13,'mx':117,'my':15},{'lx':122,'ly':12,'mx':121,'my':13},{'lx':122,'ly':11,'mx':122,'my':12},{'lx':121,'ly':11,'mx':122,'my':11},{'lx':121,'ly':10,'mx':121,'my':11},{'lx':120,'ly':10,'mx':121,'my':10},{'lx':118,'ly':8,'mx':120,'my':10},{'lx':115,'ly':7,'mx':118,'my':8},{'lx':112,'ly':5,'mx':115,'my':7},{'lx':109,'ly':3,'mx':112,'my':5},{'lx':106,'ly':3,'mx':109,'my':3},{'lx':103,'ly':3,'mx':106,'my':3},{'lx':100,'ly':3,'mx':103,'my':3},{'lx':98,'ly':4,'mx':100,'my':3},{'lx':95,'ly':5,'mx':98,'my':4},{'lx':95,'ly':7,'mx':95,'my':5},{'lx':93,'ly':8,'mx':95,'my':7},{'lx':92,'ly':10,'mx':93,'my':8},{'lx':91,'ly':11,'mx':92,'my':10},{'lx':91,'ly':13,'mx':91,'my':11},{'lx':90,'ly':15,'mx':91,'my':13},{'lx':90,'ly':16,'mx':90,'my':15},{'lx':90,'ly':18,'mx':90,'my':16},{'lx':90,'ly':19,'mx':90,'my':18},{'lx':90,'ly':21,'mx':90,'my':19},{'lx':90,'ly':22,'mx':90,'my':21},{'lx':90,'ly':23,'mx':90,'my':22},{'lx':90,'ly':22,'mx':90,'my':23},{'lx':90,'ly':21,'mx':90,'my':22},{'lx':89,'ly':21,'mx':90,'my':21},{'lx':87,'ly':21,'mx':89,'my':21},{'lx':85,'ly':20,'mx':87,'my':21},{'lx':85,'ly':21,'mx':85,'my':20},{'lx':84,'ly':21,'mx':85,'my':21},{'lx':84,'ly':22,'mx':84,'my':21},{'lx':84,'ly':23,'mx':84,'my':22},{'lx':84,'ly':25,'mx':84,'my':23},{'lx':84,'ly':27,'mx':84,'my':25},{'lx':84,'ly':28,'mx':84,'my':27},{'lx':85,'ly':29,'mx':84,'my':28},{'lx':87,'ly':30,'mx':85,'my':29},{'lx':88,'ly':31,'mx':87,'my':30},{'lx':90,'ly':32,'mx':88,'my':31},{'lx':108,'ly':33,'mx':90,'my':32},{'lx':113,'ly':33,'mx':108,'my':33},{'lx':118,'ly':32,'mx':113,'my':33},{'lx':122,'ly':30,'mx':118,'my':32},{'lx':127,'ly':28,'mx':122,'my':30},{'lx':134,'ly':28,'mx':127,'my':28},{'lx':147,'ly':24,'mx':134,'my':28},{'lx':150,'ly':23,'mx':147,'my':24},{'lx':152,'ly':22,'mx':150,'my':23},{'lx':152,'ly':21,'mx':152,'my':22},{'lx':153,'ly':21,'mx':152,'my':21},{'lx':154,'ly':21,'mx':153,'my':21},{'lx':154,'ly':20,'mx':154,'my':21},{'lx':155,'ly':20,'mx':154,'my':20},{'lx':155,'ly':19,'mx':155,'my':20},{'lx':156,'ly':19,'mx':155,'my':19},{'lx':157,'ly':19,'mx':156,'my':19},{'lx':158,'ly':19,'mx':157,'my':19},{'lx':159,'ly':19,'mx':158,'my':19},{'lx':161,'ly':19,'mx':159,'my':19},{'lx':164,'ly':19,'mx':161,'my':19},{'lx':166,'ly':19,'mx':164,'my':19},{'lx':168,'ly':19,'mx':166,'my':19},{'lx':169,'ly':20,'mx':168,'my':19},{'lx':172,'ly':20,'mx':169,'my':20},{'lx':173,'ly':20,'mx':172,'my':20},{'lx':175,'ly':19,'mx':173,'my':20},{'lx':176,'ly':19,'mx':175,'my':19},{'lx':177,'ly':19,'mx':176,'my':19},{'lx':178,'ly':19,'mx':177,'my':19}]";
		ServletOutputStream sos = null;
		try {
			BufferedImage bi = SignatureToImage.convertJsonToImage(dataUrl);
			sos = response.getOutputStream();
			response.setHeader("Content-disposition", "inline; filename=\"signature.jpg\"");
			response.setContentType("image/jpeg");
			ImageIO.write(bi, "JPEG", sos);
//			SigGen.generateSignature(dataUrl, sos);
		} catch (Exception e) {
			System.err.println("exception: " + e.getMessage());
		} finally {
			try {
				sos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	private void setInjuryLocationsWithOutSubs(AccidentModel accident) {
		List<InjuryLocationsModel> list = injuryLocationsService.getInjuryLocationsWithoutSub();
		int[] injNonSub = new int[list.size()];
		int loop = 0;
		for (InjuryLocationsModel ilm : list) {
			injNonSub[loop++] = ilm.getId();
		}
		accident.setNonSubInj(injNonSub);
	}

}
