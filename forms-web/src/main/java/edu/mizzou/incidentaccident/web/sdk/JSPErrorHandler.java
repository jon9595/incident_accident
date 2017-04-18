package edu.mizzou.incidentaccident.web.sdk;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mizzou.incidentaccident.api.common.util.DateUtil;
import edu.mizzou.incidentaccident.api.constants.AppConstants;

/**
 * Class: 		JSPErrorHandler.java
 * Date:  		Mar 30, 2006
 * Description:	
 * <p>Error handler to print the errors generated from a JSP</p>
 * 
 * @author Michael R. Dirks
 */
public class JSPErrorHandler {

	private static Logger log = LoggerFactory.getLogger(JSPErrorHandler.class);
	private static String TO = "mdirks@leewardassociates.com";
	private static String SUBJECT = "500 Error in Incident Accident Form Application";
	
	
	public static String debug(HttpServletRequest request, Throwable e)
	{
		String dateTime = DateUtil.format(new Date(), AppConstants.DATE_FORMAT_PATTERN_YYYYMMDDHMSMS);
		String errMsg = buildErrorMessage(dateTime, request, e);
		if(log.isDebugEnabled())
			log.debug(errMsg);
		return dateTime;	
	}
	
	public static boolean isDebugEnabled()
	{
		return log.isDebugEnabled();
	}
	
	protected static String buildErrorMessage(String dateTime, HttpServletRequest request, Throwable e)
	{
		// Store the user id so that we can associate that with the response time to 
		// easily track users and their transactions
		HttpSession session = request.getSession();
		StringBuffer sb = new StringBuffer();
		sb.append("[JSP ERROR],")
		.append(" ["+dateTime+"], ")
		.append(" [Request URL: "+request.getRequestURL()+"],")
		.append(" [IP Address: "+request.getRemoteAddr()+"],")
		.append(" [error:"+e.getClass().getName()+"],")
		.append(" [message: "+e.getMessage()+"]")
		.append("\r");
		return sb.toString();
	}
}
