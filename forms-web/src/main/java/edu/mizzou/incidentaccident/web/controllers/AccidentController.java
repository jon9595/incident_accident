package edu.mizzou.incidentaccident.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/accidents")
public class AccidentController {

	@RequestMapping(value="/create")
	public String createAccidentForm(ModelMap map) {
		return "accident.create";
	}
}
