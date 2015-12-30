package edu.mizzou.incidentaccident.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mizzou.incidentaccident.api.models.IncidentModel;
import edu.mizzou.incidentaccident.api.models.UsersModel;
import edu.mizzou.incidentaccident.api.services.UsersService;
import edu.mizzou.incidentaccident.web.validators.UsersValidator;

@Controller
@RequestMapping(value="/users")
public class UsersController {

	private static Logger log = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private UsersService usersService; 
	
	@Autowired
	private UsersValidator usersValidator;
	
	@RequestMapping(value="/list")
	public String getUserList(ModelMap map) {
		map.addAttribute("users", usersService.getUsersList());
		return "users.list";
	}

	@RequestMapping(value="/view/{id}")
	public String displayUser(@PathVariable String id, ModelMap map) {
		map.addAttribute("user", usersService.getUsers(new Integer(id)));
		return "users.view";
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editUserForm(@PathVariable String id, ModelMap map) {
		map.addAttribute("usersForm", usersService.getUsers(new Integer(id)));
		return "users.edit";
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String changeUserForm(@ModelAttribute("usersForm") UsersModel user, BindingResult result, ModelMap map, HttpServletRequest request) {
		usersValidator.validate(user, result);
		if (result.hasErrors()) {
			map.addAttribute("errMsg", "Please fix belows errors before submitting.");
			map.addAttribute("usersForm", user);
			return "users.edit";
		} else {
			user.setModifiedBy(request.getUserPrincipal().getName());
			usersService.updateUsers(user);
			return "redirect:/users/list";
		}
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createUser(ModelMap map) {
		map.addAttribute("usersForm", new UsersModel());
		return "users.create";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String saveUsersForm(@ModelAttribute("usersForm") UsersModel user, BindingResult result, ModelMap map, HttpServletRequest request) {
		usersValidator.validateCreation(user, result);
		if (result.hasErrors()) {
			map.addAttribute("errMsg", "Please fix belows errors before submitting.");
			map.addAttribute("usersForm", user);
			return "users.create";
		} else {
			user.setCreatedBy(request.getUserPrincipal().getName());
			usersService.adduser(user);
			return "redirect:/users/list";
		}
	}
}