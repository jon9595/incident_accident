package edu.mizzou.incidentaccident.web.controllers;

import javax.mail.Address;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mizzou.incidentaccident.api.models.UsersModel;
import edu.mizzou.incidentaccident.api.services.UsersService;
import edu.mizzou.incidentaccident.web.validators.UsersValidator;

import edu.mizzou.incidentaccident.api.models.EmailModel;
import edu.mizzou.incidentaccident.api.services.EmailService;

@Controller
@RequestMapping(value="/users")
public class UsersController {

	private static Logger log = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private UsersService usersService; 
	
	@Autowired
	private UsersValidator usersValidator;
	
	@Autowired
	private EmailService emailService;
	
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
	
	@RequestMapping(value="/changePasswd/{username}", method=RequestMethod.GET)
	public String changePassword(@PathVariable String username, ModelMap map) {
		map.addAttribute("usersForm", usersService.getUserByUsername(username));
		return "users.changePasswd";
	}
	
	@RequestMapping(value="/changePasswd", method=RequestMethod.POST)
	public String savePasswordChanges(@ModelAttribute("usersForm") UsersModel user, BindingResult result, ModelMap map, HttpServletRequest request) {
		usersValidator.validatePasswordChange(user, result);
		if (!usersService.validateUser(user.getUsername(), user.getOldPassword())) {
			result.rejectValue("oldPassword", "required", null, "Invalid password.");
		}
		if (result.hasErrors()) {
			map.addAttribute("errMsg", "Please fix belows errors before submitting.");
			map.addAttribute("usersForm", user);
			return "users.changePasswd";
		} else {
			usersService.updatePassword(user.getUsername(), user.getPassword(),request.getUserPrincipal().getName());
			if (request.getUserPrincipal().getName().equals(user.getUsername())) {
				return "redirect:/users/profile";
			} else {
				return "redirect:/users/view/"+user.getId();
			}
		}
	}

	
	@RequestMapping(value="/profile")
	public String getProfile(ModelMap map, HttpServletRequest request) {
		map.addAttribute("user", usersService.getUserByUsername(request.getUserPrincipal().getName()));
		return "users.profile";
	}

	@RequestMapping(value="/editProfile", method=RequestMethod.GET)
	public String editProfile(ModelMap map, HttpServletRequest request) {
		map.addAttribute("usersForm", usersService.getUserByUsername(request.getUserPrincipal().getName()));
		return "users.profile.edit";
	}

	@RequestMapping(value="/editProfile", method=RequestMethod.POST)
	public String saveProfileChanges(@ModelAttribute("usersForm") UsersModel user, BindingResult result, ModelMap map, HttpServletRequest request) {
		usersValidator.validate(user, result);
		if (result.hasErrors()) {
			map.addAttribute("errMsg", "Please fix belows errors before submitting.");
			map.addAttribute("usersForm", user);
			return "users.profile.edit";
		} else {
			user.setModifiedBy(request.getUserPrincipal().getName());
			usersService.updateProfile(user);
			return "redirect:/users/profile";
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
		if(usersService.getUserByUsername(user.getUsername())!=null) {
			result.rejectValue("username", "required", null, "This username is already taken.");
		}
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
	
	@RequestMapping(value="/updateEmail", method=RequestMethod.GET)
	public String getEmailList(ModelMap map) {
		map.addAttribute("users", usersService.getUsersList());
		map.addAttribute("emails", emailService.getEmailList());
		return "users.updateEmail";
	}
	
	@RequestMapping(value="/updateEmail", method=RequestMethod.POST)
	public String updateEmailList(@ModelAttribute("emailForm") EmailModel email, BindingResult result, ModelMap map, HttpServletRequest request) {
		emailService.addEmail(email);
		
		return "redirect:/users/updateEmail";
	}
	
	@RequestMapping(value="/remove/{id}")
	public String removeUser(@PathVariable String id) {
		usersService.deleteUsers(new Integer(id));
		return "redirect:/users/list";
	}
}