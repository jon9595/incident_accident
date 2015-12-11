package edu.mizzou.incidentaccident.web.controllers;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mizzou.incidentaccident.api.common.util.SigGen;
import edu.mizzou.incidentaccident.api.models.AccidentModel;
import edu.mizzou.incidentaccident.api.models.InjuryLocationsModel;
import edu.mizzou.incidentaccident.api.services.AccidentDetailDescriptionService;
import edu.mizzou.incidentaccident.api.services.AccidentService;
import edu.mizzou.incidentaccident.api.services.InjuryLocationsService;
import edu.mizzou.incidentaccident.api.services.LocationsService;
import edu.mizzou.incidentaccident.web.validators.AccidentValidator;

@Controller
@RequestMapping(value="/accident")
public class AccidentController {

	@Autowired
	AccidentService accidentService;
	
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
			map.addAttribute("accidentForm", accident);
			map.addAttribute("locationsMap", locationsService.getLocations());
			map.addAttribute("injuryLocationsMap", injuryLocationsService.getInjuryLocations());
			map.addAttribute("accidentDetailDesc", accidentDetailDescriptionService.getAccidentDetailDescriptionList());
			return "accident.create";
		} else {
			accident.setCreatedBy(request.getUserPrincipal().getName());
			accidentService.addAccident(accident);
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

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String changeAccidentForm(@ModelAttribute("accidentForm") AccidentModel accident, BindingResult result, ModelMap map, HttpServletRequest request) {
		setInjuryLocationsWithOutSubs(accident);
		accidentValidator.validate(accident, result);
		if (result.hasErrors()) {
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

	@RequestMapping(value="/list")
	public String getAccidentList(ModelMap map) {
		map.addAttribute("accidents", accidentService.getAccidentList());
		return "accident.list";
	}

	@RequestMapping(value="/view/{id}")
	public String displayAccidentReport(@PathVariable String id, ModelMap map) {
		map.addAttribute("accident", accidentService.getAccident(new Integer(id)));
		return "accident.view";
	}
		
	@RequestMapping(value="/signature")
	public void generateSignatureImage(HttpServletResponse response) {
		String dataUrl = "image/jsignature;base30,4Q0112201021022121Z201000Y2322222342222222022Z1000Y1222031222132223322200Z2200Y22132220Z203100Y22221F66645100Z143665666666443Y43334412200002a445442212000Z212121211221221221202010Y3586a1vjjjhf99976541220Z236dfhjlhhdddd97653Y4cfhhllljjllllljhd9997654_1J7665656656566645Zb9bababj8743Y49ddddddbb963Z558a9a885Y89a7867Z48fdbb75Y5678864Z448886Y645Zcadcd9960Y55556666543442324544423Z1545569a9988981Y6666665666595655654Z8566566666656665531100Y2Z2200Y2022232243664567777775523221222Z2555523322322232220100002_eW_1L_7z3_1I2";
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			response.setHeader("Content-disposition", "inline; filename=\"signature.jpg\"");
			response.setContentType("image/jpeg");
			SigGen.generateSignature(dataUrl, sos);
		} catch (Exception e) {
			
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
