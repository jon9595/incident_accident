<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"/ >
<script src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.min.js"></script>
<script>
$(document).ready(function(){
	$('#incident_date_start').datetimepicker({
		  format:'m/d/Y',
		  onShow:function( ct ){
		   this.setOptions({
		    maxDate:$('#incident_date_end').val()?$('#incident_date_end').val():false
		   })
		  },
		  timepicker:false
		 });
		 $('#incident_date_end').datetimepicker({
		  format:'m/d/Y',
		  onShow:function( ct ){
		   this.setOptions({
		    minDate:$('#incident_date_start').val()?$('#incident_date_start').val():false
		   })
		  },
		  timepicker:false
		 });	


			$('#accident_date_start').datetimepicker({
				  format:'m/d/Y',
				  onShow:function( ct ){
				   this.setOptions({
				    maxDate:$('#accident_date_end').val()?$('#accident_date_end').val():false
				   })
				  },
				  timepicker:false
				 });
				 $('#accident_date_end').datetimepicker({
				  format:'m/d/Y',
				  onShow:function( ct ){
				   this.setOptions({
				    minDate:$('#accident_date_start').val()?$('#accident_date_start').val():false
				   })
				  },
				  timepicker:false
				 });	

});
</script>
    <div class="form-container color-black">
    	<fieldset>
    	<legend>Reports Needing Approval</legend>
	    <div class="row">
	    <div class="col-md-6">
	    <h3>Incident Reports</h3>
	    <ul>
	    <c:forEach items="${incidents}" var="incident">
	    	<li><a href="${pageContext.request.contextPath}/incident/view/${incident.id}"><fmt:formatDate value="${incident.demographics.date}" pattern="MM/dd/yyyy"/> - ${incident.demographics.name} - ${incident.incidentDetailsDesc}</a></li>
	    </c:forEach>
	    </ul>
	    </div>
	    <div class="col-md-6">
	    <h3>Accident Reports</h3>
	    <ul>
	    <c:forEach items="${accidents}" var="accident">
	    	<li><a href="${pageContext.request.contextPath}/accident/view/${accident.id}"><fmt:formatDate value="${accident.demographics.date}" pattern="MM/dd/yyyy"/> - ${accident.demographics.name} - ${accident.accidentDetailsDesc}</a></li>
	    </c:forEach>
	    </ul>
	    </div>
	    </div>
    	</fieldset>
    	<br/>
    	<fieldset>
    		<legend>Search Incident Reports</legend>
    		<div class="well">
<form class="form-inline" role="form" method="get" action="#">
<div class="row">
<div class="col-md-4">
	<div class="form-group">
		<div class="col-md-12 padding-left-none"><label for="incident_name">Name:</label></div>
		<input type="text" class="form-control" id="incident_name" placeholder="Enter name to search" />
	</div>
</div>
<div class="col-md-4">
	<div class="form-group">
		<div class="col-md-12 padding-left-none"><label for="incident_member_status">Member Status:</label></div>
		<select id="incident_member_status" class="form-control">
			<option value="">--Member Status--</option>
			<option value="alumni">Alumni</option>
			<option value="facultyStaff">Faculty/Staff</option>
			<option value="guest">Guest</option>
			<option value="houseHoldAdult">Household Adult</option>
			<option value="other">Other</option>
			<option value="stopOutStudent">Stop Out Student</option>
			<option value="student">Student</option>
			<option value="tigerXpress">Tiger XPress</option>
		</select>
	</div>
</div>
<div class="col-md-4">
<div class="form-group">
	<div class="col-md-12 padding-left-none"><label for="incident_nature">Incident Nature:</label></div>
	<select id="incident_nature" class="form-control">
		<option value="">--Incident Natures--</option>
<c:forEach items="${incidentNatures}" var="nature">
		<option value="${nature.id}">${nature.description}</option>
</c:forEach>
	</select>
</div>
</div>
</div>
<div class="row margin-top-lg">
<div class="col-md-4">
	<div class="form-group">
		<div class="col-md-12 padding-left-none"><label for="incident_date_start">Start:</label></div>
		<input type="text" class="form-control" id="incident_date_start" placeholder="Enter start date" />
	</div>
</div>
<div class="col-md-4">
	<div class="form-group">
		<div class="col-md-12 padding-left-none"><label for="incident_date_end">End:</label></div>
		<input type="text" class="form-control" id="incident_date_end" placeholder="Enter end date" />
	</div>
</div>
<div class="col-md-4">
</div>
</div>
<div class="row margin-top-lg">
<div class="col-md-12">
	<div class="form-group pull-right">
	<button type="submit" class="btn btn-primary btn-large form-control padding-left-xl padding-right-xl">Search</button>
	</div>
</div>
</div>

</form>
    		</div>
    	</fieldset>
    	<br/>
    	<fieldset>
    		<legend>Search Accident Reports</legend>
    		<div class="well">
<form class="form-inline" role="form" method="get" action="#">
<div class="row">
<div class="col-md-4">
	<div class="form-group">
		<div class="col-md-12 padding-left-none"><label for="accident_name">Name:</label></div>
		<input type="text" class="form-control" id="accident_name" placeholder="Enter name to search" />
	</div>
</div>
<div class="col-md-4">
	<div class="form-group">
		<div class="col-md-12 padding-left-none"><label for="accident_member_status">Member Status:</label></div>
		<select id="accident_member_status" class="form-control">
			<option value="">--Member Status--</option>
			<option value="alumni">Alumni</option>
			<option value="facultyStaff">Faculty/Staff</option>
			<option value="guest">Guest</option>
			<option value="houseHoldAdult">Household Adult</option>
			<option value="other">Other</option>
			<option value="stopOutStudent">Stop Out Student</option>
			<option value="student">Student</option>
			<option value="tigerXpress">Tiger XPress</option>
		</select>
	</div>
</div>
<div class="col-md-4">
<div class="form-group">
	<div class="col-md-12 padding-left-none"><label for="accident_nature">Accident Detail:</label></div>
	<select id="accident_nature" class="form-control">
		<option value="">--Accident Detail--</option>
<c:forEach items="${accidentDescriptions}" var="desc">
		<option value="${desc.id}">${desc.description}</option>
</c:forEach>
	</select>
</div>
</div>
</div>
<div class="row margin-top-lg">
<div class="col-md-4">
	<div class="form-group">
		<div class="col-md-12 padding-left-none"><label for="accident_date_start">Start:</label></div>
		<input type="text" class="form-control" id="accident_date_start" placeholder="Enter start date" />
	</div>
</div>
<div class="col-md-4">
	<div class="form-group">
		<div class="col-md-12 padding-left-none"><label for="accident_date_end">End:</label></div>
		<input type="text" class="form-control" id="accident_date_end" placeholder="Enter end date" />
	</div>
</div>
<div class="col-md-4">
</div>
</div>
<div class="row margin-top-lg">
<div class="col-md-12">
	<div class="form-group pull-right">
	<button type="submit" class="btn btn-primary btn-large form-control padding-left-xl padding-right-xl">Search</button>
	</div>
</div>
</div>

</form>
    		</div>
    	</fieldset>
    </div>

