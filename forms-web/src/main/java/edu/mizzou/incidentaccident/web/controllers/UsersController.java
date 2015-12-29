package edu.mizzou.incidentaccident.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mizzou.incidentaccident.api.constants.AppConstants;
import edu.mizzou.incidentaccident.api.models.UsersModel;
import edu.mizzou.incidentaccident.api.services.UsersService;

@Controller
@RequestMapping(value="/users")
public class UsersController {

	private static Logger log = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private UsersService usersService; 
	


}