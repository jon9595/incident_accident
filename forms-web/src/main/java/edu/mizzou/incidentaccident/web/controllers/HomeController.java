package edu.mizzou.incidentaccident.web.controllers;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
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

import edu.mizzou.incidentaccident.api.common.util.SignatureToImage;
import edu.mizzou.incidentaccident.api.constants.AppConstants;
import edu.mizzou.incidentaccident.api.models.AccidentModel;
import edu.mizzou.incidentaccident.api.models.SignaturesModel;
import edu.mizzou.incidentaccident.api.models.UsersModel;
import edu.mizzou.incidentaccident.api.services.AccidentDetailDescriptionService;
import edu.mizzou.incidentaccident.api.services.AccidentService;
import edu.mizzou.incidentaccident.api.services.IncidentNatureService;
import edu.mizzou.incidentaccident.api.services.IncidentService;
import edu.mizzou.incidentaccident.api.services.SignaturesService;
import edu.mizzou.incidentaccident.web.models.AccidentSearchForm;
import edu.mizzou.incidentaccident.web.models.IncidentSearchForm;

@Controller
public class HomeController {

	@Autowired
	private SignaturesService signaturesService;
	@Autowired
	private AccidentService accidentService;
	@Autowired
	private IncidentService incidentService;
	@Autowired
	private IncidentNatureService incidentNatureService;
	@Autowired
	private AccidentDetailDescriptionService accidentDetailDescriptionService;
	
	@RequestMapping(value="/logout")
	public String logoff(ModelMap map, HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String index(ModelMap map, HttpServletRequest request) {
		map.addAttribute("accidents", accidentService.getAccidentNeedingApproval());
		map.addAttribute("incidents", incidentService.getIncidentsNeedingApproval());
		map.addAttribute("incidentNatures", incidentNatureService.getIncidentNatureList());
		map.addAttribute("accidentDescriptions", accidentDetailDescriptionService.getAccidentDetailDescriptionList());
		map.addAttribute("accidentSearchForm", new AccidentSearchForm());
		map.addAttribute("incidentSearchForm", new IncidentSearchForm());
		return "main.index";
	}
	
	@RequestMapping(value="/searchAccidents", method=RequestMethod.POST) 
	public String searchAccidents(@ModelAttribute("accidentSearchForm") AccidentSearchForm searchForm, BindingResult result, ModelMap map) {
		map.addAttribute("accidents", accidentService.getAccidentListFromSearch(searchForm.generateWhereClause()));
		return "accident.list";
	}

	@RequestMapping(value="/searchIncidents", method=RequestMethod.POST) 
	public String searchIncidents(@ModelAttribute("incidentSearchForm") IncidentSearchForm searchForm, BindingResult result, ModelMap map) {
		map.addAttribute("incidents", incidentService.getIncidentListFromSearch(searchForm.generateWhereClause()));
		return "incident.list";
	}

	@RequestMapping(value="/displaySignature/{id}")
	public void displaySignature(@PathVariable String id, ModelMap map, HttpServletResponse response) {
		ServletOutputStream sos = null;
		try {
			SignaturesModel signature = signaturesService.getSignatures(new Integer(id));
			if (signature != null) {
				sos = response.getOutputStream();
				response.setHeader("Content-disposition", "inline; filename=\"signature.jpg\"");
				response.setContentType("image/png");
				sos.write(signature.getData());
			}
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
	
	@RequestMapping(value="/regenSignature/{id}")
	public void regenSignature(@PathVariable String id, ModelMap map, HttpServletResponse response) {
		ServletOutputStream sos = null;
		try {
			SignaturesModel signature = signaturesService.getSignatures(new Integer(id));
			if (signature != null) {
				BufferedImage bi = SignatureToImage.convertJsonToImage(signature.getJsonData());
				sos = response.getOutputStream();
				response.setHeader("Content-disposition", "inline; filename=\"signature.jpg\"");
				response.setContentType("image/png");
				ImageIO.write(bi, "PNG", sos);			}
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
	
}