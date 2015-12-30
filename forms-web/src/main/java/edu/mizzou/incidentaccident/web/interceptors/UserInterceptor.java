package edu.mizzou.incidentaccident.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.mizzou.incidentaccident.api.constants.AppConstants;
import edu.mizzou.incidentaccident.api.models.UsersModel;
import edu.mizzou.incidentaccident.api.services.UsersService;

public class UserInterceptor extends HandlerInterceptorAdapter {
	
	private static Logger log = LoggerFactory.getLogger(UserInterceptor.class);

	@Autowired
	private UsersService usersService;
	
	public static UsersModel prevUser = null;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		populateUserProfile(request);
		return true;
	}


	private void populateUserProfile(HttpServletRequest request)
	{
    	UsersModel user = null;
		HttpSession session = request.getSession();
		// User is logged in
		if (request.getUserPrincipal()!=null && StringUtils.isNotBlank(request.getUserPrincipal().getName())) {
			user = (UsersModel)session.getAttribute(AppConstants.USER_PROFILE);
			// User is either not in the session or is the wrong user
			if (user==null || !request.getUserPrincipal().getName().equals(user.getUsername())) {
				// Set the new user attribute into the session
				session.setAttribute(AppConstants.USER_PROFILE, usersService.getUserByUsername(request.getUserPrincipal().getName()));
				user = (UsersModel)session.getAttribute(AppConstants.USER_PROFILE);
			}
			if (prevUser == null && user != null) {
				usersService.setLastLoggedIn(request.getUserPrincipal().getName());
			}
			prevUser = user;
		} else {
			prevUser = null;
		}
	}	

}
