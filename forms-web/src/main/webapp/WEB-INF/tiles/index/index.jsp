<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/mask/jquery.mask.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"/ >
<script src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mizrec.js"></script>
<script>
$(document).ready(function(){
	 $('.date').mask('00/00/0000');
	 $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
	     var href = e.target['href'];
	     if(href.indexOf('#searchIncidentTab') >= 0) {
	    	 $('#incident_name').focus();
	     } else {
	    	 $('#accident_name').focus();
	     }
	 })				 
    $('#accidentList.table-hover > tbody > tr').click(function(){
    	var id = $(this).find('td:first').text();
    	location.href= '${pageContext.request.contextPath}/accident/view/'+id;
    });
    $('#incidentList.table-hover > tbody > tr').click(function(){
    	var id = $(this).find('td:first').text();
    	location.href= '${pageContext.request.contextPath}/incident/view/'+id;
    });
    $('.btn-accident').click(function(){
    	location.href= '${pageContext.request.contextPath}/accident/create';
    });
    $('.btn-incident').click(function(){
    	location.href= '${pageContext.request.contextPath}/incident/create';
    });
				 
});
</script>
    <div class="form-container color-black margin-top-xl">
	    <div class="row">
	    <div class="col-md-6">
	    <button class="btn btn-primary btn-incident btn-large padding-left-xl padding-right-xl margin-bottom-lg center-block visible-xs"><i class="fa fa-exclamation-triangle"></i> &nbsp;&nbsp;<h6>New Incident Report</h8></button>
	    <button class="btn btn-primary btn-incident btn-large padding-left-xl padding-right-xl margin-bottom-lg center-block hidden-xs"><i class="fa fa-exclamation-triangle fa-2x"></i> &nbsp;&nbsp;<h4>Create New Incident Report</h4></button>
	    </div>
	    <div class="col-md-6">
	    <button class="btn btn-golden btn-accident btn-large padding-left-xl padding-right-xl center-block visible-xs"><i class="fa fa-ambulance"></i> &nbsp;&nbsp;<h6>New Accident Report</h6></button>
	    <button class="btn btn-golden btn-accident btn-large padding-left-xl padding-right-xl center-block hidden-xs"><i class="fa fa-ambulance fa-2x"></i> &nbsp;&nbsp;<h4>Create New Accident Report</h4></button>
	    </div>
	    </div>
    </div>

          <c:if test="${sessionScope.userProfile.admin || sessionScope.userProfile.manager}">
    <div class="form-container color-black">
    	<fieldset>
    	<legend>Reports Needing Approval</legend>
	    <div class="row">
	    <div class="col-md-6">
	    <h3>Incident Reports</h3>
	    <ul>
	    <c:choose>
	    	<c:when test="${empty incidents}">
	    	None
	    	</c:when>
	    	<c:otherwise>
	    <c:forEach items="${incidents}" var="incident">
	    	<li><a href="${pageContext.request.contextPath}/incident/view/${incident.id}"><fmt:formatDate value="${incident.incidentDate}" pattern="MM/dd/yyyy"/> - ${incident.name} - ${incident.incidentDetails}</a></li>
	    </c:forEach>
	    	</c:otherwise> 
	    </c:choose>
	    </ul>
	    </div>
	    <div class="col-md-6">
	    <h3>Accident Reports</h3>
	    <ul>
	    <c:forEach items="${accidents}" var="accident">
	    	<li><a href="${pageContext.request.contextPath}/accident/view/${accident.id}"><fmt:formatDate value="${accident.accidentDate}" pattern="MM/dd/yyyy"/> - ${accident.name} - ${accident.accidentDescription}</a></li>
	    </c:forEach>
	    </ul>
	    </div>
	    </div>
    	</fieldset>
    </div>
    </c:if>
    <c:if test="${!(empty incidentList)}">
    <div class="form-container color-black">
    	<fieldset>
    	<legend>Most Recent Incident Reports (past month)</legend>
    	<div class="row">
    		<div class="col-md-12 col-lg-12 table-responsive">
			<table class="table table-hover table-striped" id="incidentList">
		        <thead>
		        	<th class="hidden"></th>
		        	<th>Date/Time</th>
		        	<th>Name/Address</th>
		        	<th>Membership Status</th>
		        	<th>Incident Details</th>
		        	<th>Location</th>
		        </thead>
		        <tbody>
			<c:forEach items="${incidentList}" var="incident">
				<tr>
					<td class="hidden">${incident.id}</td>
					<td align="left"><fmt:formatDate value="${incident.incidentDate}" pattern="MM/dd/yyyy"/><br/><fmt:formatDate value="${incident.incidentDate}" pattern="hh:mm a"/></td>
					<td>${incident.name}<br/>${incident.address}</td>
					<td>${incident.membershipStatus.membershipStatus}</td>
					<td><pre>${incident.incidentDetails}</pre></td>
					<td><pre>${incident.location}</pre></td>
				</tr>
			</c:forEach>	        
		        </tbody>
	        </table>
    		</div>
    	</div>
    	</fieldset>
    </div>
    </c:if>
    <c:if test="${!(empty accidentList)}">
    <div class="form-container color-black">
    	<fieldset>
    	<legend>Most Recent Accident Reports (past month)</legend>
    	<div class="row">
    		<div class="col-md-12 col-lg-12 table-responsive">
	        <table class="table table-hover table-striped" id="accidentList">
		        <thead>
		        	<th class="hidden"></th>
		        	<th>Date/Time</th>
		        	<th>Name/Address</th>
		        	<th>Membership Status</th>
		        	<th>Location</th>
		        	<th>Injury Location</th>
		        	<th>EMS</th>
		        </thead>
		        <tbody>
	<c:forEach items="${accidentList}" var="accident">
					<tr>
						<td class="hidden">${accident.id}</td>
						<td align="left"><fmt:formatDate value="${accident.accidentDate}" pattern="MM/dd/yyyy"/><br/><fmt:formatDate value="${accident.accidentDate}" pattern="hh:mm a"/></td>
						<td>${accident.name}<br/>${accident.address}</td>
						<td>${accident.membershipStatus.membershipStatus}</td>
						<td><pre>${accident.location}</pre></td>
						<td><pre>${accident.injuryLocation}</pre></td>
						<td>${accident.emsContacted}</td>
					</tr>
	</c:forEach>	        
		        </tbody>
	        </table>
    		</div>
    	</div>
    	</fieldset>
    </div>
    </c:if>
    
    <div class="form-container color-black">
 	<ul class="nav nav-tabs" role="tablist">
	    <li role="presentation" class="active"><a href="#searchIncidentTab" aria-controls="searchIncidentTab" role="tab" data-toggle="tab">Search Incident Reports</a></li>
	    <li role="presentation"><a href="#searchAccidentTab" aria-controls="searchAccidentTab" role="tab" data-toggle="tab">Search Accident Reports</a></li>
  	</ul>

	<!-- Tab panes -->
	<div class="tab-content padding-top-lg">
		<div role="tabpanel" class="tab-pane active" id="searchIncidentTab">
              <jsp:include page="/WEB-INF/jsp/modules/search-incidents.jsp"/>
		</div>
		<div role="tabpanel" class="tab-pane" id="searchAccidentTab">
              <jsp:include page="/WEB-INF/jsp/modules/search-accidents.jsp"/>
		</div>
	</div>	
	</div>

