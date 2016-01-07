package edu.mizzou.incidentaccident.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mizzou.incidentaccident.api.models.AccidentModel;
import edu.mizzou.incidentaccident.api.models.IncidentModel;
import edu.mizzou.incidentaccident.api.services.AccidentService;
import edu.mizzou.incidentaccident.api.services.IncidentIncidentNatureService;
import edu.mizzou.incidentaccident.api.services.IncidentNatureService;
import edu.mizzou.incidentaccident.api.services.IncidentService;
import edu.mizzou.incidentaccident.api.services.LocationsService;
import edu.mizzou.incidentaccident.web.validators.IncidentValidator;

@Controller
@RequestMapping(value="/incident")
public class IncidentController {

	@Autowired
	IncidentService incidentService;
	
	@Autowired
	LocationsService locationsService;
	
	@Autowired
	IncidentNatureService incidentNatureService;
	
	@Autowired
	IncidentIncidentNatureService incidentIncidentNatureService;
	
	@Autowired
	IncidentValidator incidentValidator;

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createIncidentForm(ModelMap map) {
		map.addAttribute("incidentForm", new IncidentModel());
		map.addAttribute("locationsMap", locationsService.getLocations());
		map.addAttribute("incidentDetailDesc", incidentNatureService.getIncidentNatureList());
		return "incident.create";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String saveIncidentForm(@ModelAttribute("incidentForm") IncidentModel incident, BindingResult result, ModelMap map, HttpServletRequest request) {
		incidentValidator.validate(incident, result);
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.err.println(error.toString());
			}
			System.err.println(result.getAllErrors());
			map.addAttribute("errMsg", "Please fix belows errors before submitting.");
			map.addAttribute("incidentForm", incident);
			map.addAttribute("locationsMap", locationsService.getLocations());
			map.addAttribute("incidentDetailDesc", incidentNatureService.getIncidentNatureList());
			return "incident.create";
		} else {
			incident.setCreatedBy(request.getUserPrincipal().getName());
			incidentService.addIncident(incident);
			return "redirect:/incident/list";
		}
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editIncidentForm(@PathVariable String id, ModelMap map) {
		map.addAttribute("incidentForm", incidentService.getIncident(new Integer(id)));
		map.addAttribute("locationsMap", locationsService.getLocations());
		map.addAttribute("incidentDetailDesc", incidentNatureService.getIncidentNatureList());
		return "incident.edit";
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String changeIncidentForm(@ModelAttribute("incidentForm") IncidentModel incident, BindingResult result, ModelMap map, HttpServletRequest request) {
		incidentValidator.validate(incident, result);
		if (result.hasErrors()) {
			map.addAttribute("errMsg", "Please fix belows errors before submitting.");
			map.addAttribute("incidentForm", incident);
			map.addAttribute("locationsMap", locationsService.getLocations());
			map.addAttribute("incidentDetailDesc", incidentNatureService.getIncidentNatureList());
			return "incident.edit";
		} else {
			incident.setModifiedBy(request.getUserPrincipal().getName());
			incidentService.updateIncident(incident);
			return "redirect:/incident/list";
		}
	}

	@RequestMapping(value="/approve/{id}", method=RequestMethod.GET)
	public String approveIncidentForm(@PathVariable String id, ModelMap map, HttpServletRequest request) {
		IncidentModel incident = incidentService.getIncident(new Integer(id));
		incidentService.approveAccidentReport(incident.getProperNotificationsId(), request.getUserPrincipal().getName());
		return "redirect:/incident/view/"+id;
	}

	@RequestMapping(value="/list")
	public String getIncidentList(ModelMap map) {
		map.addAttribute("incidents", incidentService.getIncidentList());
		return "incident.list";
	}

	@RequestMapping(value="/view/{id}")
	public String displayIncidentReport(@PathVariable String id, ModelMap map) {
		map.addAttribute("incident", incidentService.getIncident(new Integer(id)));
		return "incident.view";
	}
	
}
