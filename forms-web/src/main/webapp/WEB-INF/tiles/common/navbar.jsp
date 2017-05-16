<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <!-- Fixed navbar -->
  <div class="navbar navbar-default navbar-fixed-top noprint" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="http://www.mizzourec.com/"></a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li><a href="${pageContext.request.contextPath}/">Home</a></li>
          <li class="dropdown">
          	<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-ambulance"></i> Accident Reports <b class="caret"></b></a>
          	<ul class="dropdown-menu">
          	 	<li><a href="${pageContext.request.contextPath}/accident/list"><i class="fa fa-files-o fa-fw"></i>&nbsp;View Reports</a></li>
	            <li class="divider"></li>
          		<li><a href="${pageContext.request.contextPath}/accident/create"><i class="fa fa-file-text-o fa-fw"></i>&nbsp; Create New Report</a></li>
          	</ul>
          </li>
          <li><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-exclamation-triangle"></i> Incident Reports <b class="caret"></b></a>
          	<ul class="dropdown-menu">
          	 	<li><a href="${pageContext.request.contextPath}/incident/list"><i class="fa fa-files-o fa-fw"></i>&nbsp;View Reports</a></li>
	            <li class="divider"></li>
          		<li><a href="${pageContext.request.contextPath}/incident/create"><i class="fa fa-file-text-o fa-fw"></i>&nbsp; Create New Report</a></li>
          	</ul>
          </li>
          <c:if test="${sessionScope.userProfile.admin}">
          <li><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-users"></i> Users <b class="caret"></b></a>
          	<ul class="dropdown-menu">
          	 	<li><a href="${pageContext.request.contextPath}/users/list"><i class="fa fa-users fa-fw"></i>&nbsp;View Users</a></li>
	            <li class="divider"></li>
          		<li><a href="${pageContext.request.contextPath}/users/create"><i class="fa fa-user-plus fa-fw"></i>&nbsp; Create New User</a></li>
          		<li class="divider"></li>
          		<li><a href="${pageContext.request.contextPath}/users/updateEmail"><i class="fa fa-user-plus fa-fw"></i>&nbsp; Update Email List</a></li>
          	</ul>
          </li>
          </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#" class="dropdown-toggle" data-toggle="dropdown"><c:out value="${sessionScope.userProfile.name}"/>&nbsp;<i class="fa fa-cog fa-fw"></i></a>
          	<ul class="dropdown-menu">
	          <li><a href="${pageContext.request.contextPath}/users/profile" title="Manage Profile"><i class="fa fa-user fa-fw"></i>&nbsp;Edit Profile</a></li>
	            <li class="divider"></li>
              <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out fa-fw"></i>&nbsp;Logout</a></li>
          	</ul>
          </li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
