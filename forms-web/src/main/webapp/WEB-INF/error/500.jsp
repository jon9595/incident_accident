<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="edu.mizzou.incidentaccident.web.sdk.JSPErrorHandler" isErrorPage="true" %>
<%@page import="edu.mizzou.incidentaccident.api.constants.AppConstants"%>
<%
	String dateTime = JSPErrorHandler.error(request, exception);
%>

<h1>Something's Wrong!</h1>
<p>It looks as though we've broken something on our system.</p> 
<p>Not to worry!  Our wonderful staff has been notified of this and will get 
on fixing the problem real soon!</p>
<br/><br/>
<br/><br/>
<hr/>
<p>Error description: <em><%=exception.getClass().getName()%></em></p>
<p class="error">Error code: <strong><%=dateTime%></strong></p>