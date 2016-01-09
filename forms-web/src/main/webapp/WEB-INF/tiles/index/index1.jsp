<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/mask/jquery.mask.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"/ >
<script src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.min.js"></script>
<script>
$(document).ready(function(){
    $('.date').mask('00/00/0000');
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
    </div>
    <div class="form-container color-black">
 	<ul class="nav nav-tabs" role="tablist">
	    <li role="presentation" class="active"><a href="#searchIncidentTab" aria-controls="searchIncidentTab" role="tab" data-toggle="tab">Search Incident Reports</a></li>
	    <li role="presentation"><a href="#searchAccidentTab" aria-controls="searchAccidentTab" role="tab" data-toggle="tab">Search Accident Reports</a></li>
  	</ul>

	<!-- Tab panes -->
	<div class="tab-content padding-top-lg">
		<div role="tabpanel" class="tab-pane active" id="searchIncidentTab">
            <html:form method="post" modelAttribute="incidentSearchForm" action="${pageContext.request.contextPath}/searchIncidents" class="form-inline" role="form">
			<div class="panel panel-default	">
			  <div class="panel-heading">
			    <h3 class="panel-title">Search Incident Reports</h3>
			  </div>
			  <div class="panel-body">
				<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<div class="col-md-12 padding-left-none"><label for="incident_name">Name:</label></div>
						<html:input type="text" cssClass="form-control" id="incident_name" placeholder="Enter name to search" path="name" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<div class="col-md-12 padding-left-none"><label for="incident_member_status">Member Status:</label></div>
						<html:select id="incident_member_status" cssClass="form-control" path="memberStatus">
							<option value="">--Member Status--</option>
							<option value="alumni">Alumni</option>
							<option value="faculty_staff">Faculty/Staff</option>
							<option value="guest">Guest</option>
							<option value="house_hold_adult">Household Adult</option>
							<option value="other">Other</option>
							<option value="stop_out_student">Stop Out Student</option>
							<option value="student">Student</option>
							<option value="tiger_xpress">Tiger XPress</option>
						</html:select>
					</div>
				</div>
				<div class="col-md-4">
				<div class="form-group">
					<div class="col-md-12 padding-left-none"><label for="incident_nature">Incident Nature:</label></div>
					<html:select id="incident_nature" cssClass="form-control" path="incidentNature">
						<option value="">--Incident Natures--</option>
				<c:forEach items="${incidentNatures}" var="nature">
						<option value="${nature.id}">${nature.description}</option>
				</c:forEach>
					</html:select>
				</div>
				</div>
				</div>
				<div class="row margin-top-lg">
				<div class="col-md-4">
					<div class="form-group">
						<div class="col-md-12 padding-left-none"><label for="incident_date_start">Start:</label></div>
						<div class="input-group">
							<html:input type="text" cssClass="form-control date" id="incident_date_start" placeholder="Enter start date" path="startDateStr" />
							<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<div class="col-md-12 padding-left-none"><label for="incident_date_end">End:</label></div>
						<div class="input-group">
							<html:input type="text" cssClass="form-control date" id="incident_date_end" placeholder="Enter end date" path="endDateStr"/>
							<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
						</div>
					</div>
				</div>
				<div class="col-md-4">
				</div>
				</div>
				
			  </div>
			  <div class="panel-footer">
					<button type="submit" class="btn btn-primary btn-large form-control padding-left-xl padding-right-xl pull-right">Search</button>
					<div class="clearfix"></div>
			  </div>
			</div>
				</html:form>
		</div>
		<div role="tabpanel" class="tab-pane" id="searchAccidentTab">
            <html:form method="post" modelAttribute="accidentSearchForm" action="${pageContext.request.contextPath}/searchAccidents" class="form-inline" role="form">
			<div class="panel panel-default">
			  <div class="panel-heading">
			    <h3 class="panel-title">Search Accident Reports</h3>
			  </div>
			  <div class="panel-body">
				<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<div class="col-md-12 padding-left-none"><label for="accident_name">Name:</label></div>
						<html:input type="text" cssClass="form-control" id="accident_name" placeholder="Enter name to search" path="name" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<div class="col-md-12 padding-left-none"><label for="accident_member_status">Member Status:</label></div>
						<html:select id="accident_member_status" cssClass="form-control" path="memberStatus">
							<option value="">--Member Status--</option>
							<option value="alumni">Alumni</option>
							<option value="faculty_staff">Faculty/Staff</option>
							<option value="guest">Guest</option>
							<option value="house_hold_adult">Household Adult</option>
							<option value="other">Other</option>
							<option value="stop_out_student">Stop Out Student</option>
							<option value="student">Student</option>
							<option value="tiger_xpress">Tiger XPress</option>
						</html:select>
					</div>
				</div>
				<div class="col-md-4">
				<div class="form-group">
					<div class="col-md-12 padding-left-none"><label for="accident_nature">Accident Detail:</label></div>
					<html:select id="accident_nature" class="form-control" path="accidentDetail">
						<option value="">--Accident Detail--</option>
				<c:forEach items="${accidentDescriptions}" var="desc">
						<option value="${desc.id}">${desc.description}</option>
				</c:forEach>
					</html:select>
				</div>
				</div>
				</div>
				<div class="row margin-top-lg">
				<div class="col-md-4">
					<div class="form-group">
						<div class="col-md-12 padding-left-none"><label for="accident_date_start">Start:</label></div>
						<div class="input-group">
							<html:input type="text" cssClass="form-control date" id="accident_date_start" placeholder="Enter start date" path="startDateStr" />
							<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<div class="col-md-12 padding-left-none"><label for="accident_date_end">End:</label></div>
						<div class="input-group">
							<html:input type="text" cssClass="form-control date" id="accident_date_end" placeholder="Enter end date" path="endDateStr"/>
							<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<div class="col-md-12 padding-left-none"><label for="accident_ems">EMS Contacted:</label></div>
						<html:select id="accident_ems" cssClass="form-control" path="emsContacted">
							<option value="">--Select Yes/No--</option>
							<option value="Y">Yes</option>
							<option value="N">No</option>
						</html:select>
					</div>
					</div>
				</div>
				</div>
				  <div class="panel-footer">
					<button type="submit" class="btn btn-primary btn-large form-control padding-left-xl padding-right-xl pull-right">Search</button>
						<div class="clearfix"></div>
				  </div>
				  </div>
				</html:form>
			  </div>
			</div>	
		</div>
	</div>
    </div>

