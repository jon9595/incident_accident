package edu.mizzou.incidentaccident.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mizzou.incidentaccident.api.models.AccidentModel;
import edu.mizzou.incidentaccident.api.services.AccidentService;
import edu.mizzou.incidentaccident.web.validators.AccidentValidator;

@Controller
@RequestMapping(value="/accident")
public class AccidentController {

	@Autowired
	AccidentService accidentService;
	
	@Autowired
	AccidentValidator accidentValidator;
	
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createAccidentForm(ModelMap map) {
		map.addAttribute("accidentForm", new AccidentModel());
		return "accident.create";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String saveAccidentForm(@ModelAttribute("accidentForm") AccidentModel accident, BindingResult result, ModelMap map, HttpServletRequest request) {
		accidentValidator.validate(accident, result);
		if (result.hasErrors()) {
			map.addAttribute("accidentForm", accident);
			return "accident.create";
		} else {
			accident.setCreatedBy(request.getUserPrincipal().getName());
			accidentService.addAccident(accident);
			return "redirect:/";
		}
	}

}
