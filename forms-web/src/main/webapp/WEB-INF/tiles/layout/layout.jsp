<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title><tiles:insertAttribute name="title"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
		<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	    <link href="${pageContext.request.contextPath}/fa/css/font-awesome.min.css" rel="stylesheet">
	</head>
	<body>
		<!-- Wrap all page content here -->
		<div id="wrap">
		<tiles:insertAttribute name="nav"/>		
		  
		  
		  <!-- Begin page content -->
		  <div class="container" id="content">
			<tiles:insertAttribute name="content"/>		
		  </div>
		</div>
	</body>
</html>