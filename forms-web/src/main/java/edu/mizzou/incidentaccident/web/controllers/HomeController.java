package edu.mizzou.incidentaccident.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/logout")
	public String logoff(ModelMap map, HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String index(ModelMap map, HttpServletRequest request) {
		return "main.index";
	}
	
}