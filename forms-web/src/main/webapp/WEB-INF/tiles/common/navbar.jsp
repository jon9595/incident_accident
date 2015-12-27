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
          	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Accident Reports <b class="caret"></b></a>
          	<ul class="dropdown-menu">
          	 	<li><a href="${pageContext.request.contextPath}/accident/list"><i class="fa fa-files-o fa-fw"></i>&nbsp;View Reports</a></li>
	            <li class="divider"></li>
          		<li><a href="${pageContext.request.contextPath}/accident/create"><i class="fa fa-file-text-o fa-fw"></i>&nbsp; Create New Report</a></li>
          	</ul>
          </li>
          <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">Incident Reports <b class="caret"></b></a>
          	<ul class="dropdown-menu">
          	 	<li><a href="${pageContext.request.contextPath}/incident/list"><i class="fa fa-files-o fa-fw"></i>&nbsp;View Reports</a></li>
	            <li class="divider"></li>
          		<li><a href="${pageContext.request.contextPath}/incident/create"><i class="fa fa-file-text-o fa-fw"></i>&nbsp; Create New Report</a></li>
          	</ul>
          </li>
          <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
