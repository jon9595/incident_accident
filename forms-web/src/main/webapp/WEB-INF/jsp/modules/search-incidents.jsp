<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script>
$(document).ready(function(){
    setupStartEndDates('incident_date_start', 'incident_date_end');
});
</script>
            <html:form method="post" modelAttribute="incidentSearchForm" action="${pageContext.request.contextPath}/searchIncidents" class="form-inline" role="form">
			<div class="panel panel-default	">
			  <div class="panel-heading">
			    <h3 class="panel-title">Search Incident Reports</h3>
			  </div>
			  <div class="panel-body">
				<div class="row">
				<div class="col-md-4 margin-bottom-md">
					<div class="form-group">
						<div class="col-md-12 padding-left-none"><label for="incident_name">Name:</label></div>
						<html:input type="text" cssClass="form-control" id="incident_name" placeholder="Enter name to search" path="name" />
					</div>
				</div>
				<div class="col-md-4 margin-bottom-md">
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
				<div class="col-md-4 margin-bottom-md">
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
				<div class="col-md-4 margin-bottom-md">
				</div>
				</div>
				
			  </div>
			  <div class="panel-footer">
					<button type="submit" class="btn btn-primary btn-large form-control padding-left-xl padding-right-xl pull-right">Search</button>
					<div class="clearfix"></div>
			  </div>
			</div>
				</html:form>
