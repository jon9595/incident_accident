<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>MizzouRec | Log In</title>
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
			  <!-- Fixed navbar -->
		  <div class="navbar navbar-default navbar-fixed-top" role="navigation">
		    <div class="container">
		      <div class="navbar-header">
		        <a class="navbar-brand" href="http://www.mizzourec.com/"></a>
		      </div>
		    </div>
		  </div>
		  
		  
		  <!-- Begin page content -->
		  <div class="container" id="content">
			    <div class="row">
			        <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
			            <h1 class="text-center login-title">Sign in to continue</h1>
			            <div class="account-wall">
			                <i class="profile-img fa fa-warning fa-5x"></i>
			                <form class="form-signin" action="j_security_check" method="post">
			                  <div class="input-group margin-bottom-sm">
			                    <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
			                    <input type="text" name="j_username" class="form-control" placeholder="User" required autofocus>
			                  </div>
			                  <div class="input-group margin-bottom-sm">
			                    <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
			                    <input class="form-control" type="password" name="j_password" placeholder="Password" required>
			                  </div>
			                <button class="btn btn-lg btn-golden btn-block" type="submit">
			                    Sign in</button>
			                </form>
			            </div>
			        </div>
			    </div>
		  </div>
		</div>
	</body>
</html>