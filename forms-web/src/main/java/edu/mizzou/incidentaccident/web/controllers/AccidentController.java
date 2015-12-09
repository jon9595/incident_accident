package edu.mizzou.incidentaccident.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
			return "redirect:/list";
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
			return "redirect:/list";
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
