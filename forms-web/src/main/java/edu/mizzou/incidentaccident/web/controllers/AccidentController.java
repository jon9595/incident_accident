package edu.mizzou.incidentaccident.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mizzou.incidentaccident.api.models.AccidentModel;

@Controller
@RequestMapping(value="/accident")
public class AccidentController {

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createAccidentForm(ModelMap map) {
		map.addAttribute("accidentForm", new AccidentModel());
		return "accident.create";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String saveAccidentForm(@ModelAttribute("accidentForm") AccidentModel accident, BindingResult result, ModelMap map) {
		System.err.println(accident.getDemographics());
		return "redirect:/";
	}

}
