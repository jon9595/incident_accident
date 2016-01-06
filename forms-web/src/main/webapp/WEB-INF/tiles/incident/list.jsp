<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script>
	$(document).ready(function(){
		$('#content').removeClass("container");
		$('#content').addClass("container-fluid");
	    $('.table-hover > tbody > tr').click(function(){
	    	var id = $(this).find('td:first').text();
	    	location.href= '${pageContext.request.contextPath}/incident/view/'+id;
	    });
	});
</script>
    <div class="page-header padding-top-xl">
      <h1>Incident Reports</h1>
    </div>
    <div class="form-container padding-bottom-none">
    <div class="row">
        <div class="col-md-12 col-lg-12 table-responsive">
        <table class="table table-hover table-striped">
	        <thead>
	        	<th class="hidden"></th>
	        	<th>Date/Time</th>
	        	<th>Name/Address</th>
	        	<th>Membership Status</th>
	        	<th>Incident Details</th>
	        	<th>Location</th>
	        	<th>Program Involved</th>
	        </thead>
	        <tbody>
<c:forEach items="${incidents}" var="incident">
				<tr>
					<td class="hidden">${incident.id}</td>
					<td align="left"><fmt:formatDate value="${incident.demographics.date}" pattern="MM/dd/yyyy"/><br/><fmt:formatDate value="${incident.demographics.time}" pattern="hh:mm a"/></td>
					<td>${incident.demographics.name}<br/>${incident.demographics.address}</td>
					<td>${incident.membershipStatus.membershipStatus}</td>
					<td><pre>${incident.incidentDetailsDesc}</pre></td>
					<td><pre>${incident.incidentLocationDesc}</pre></td>
					<td><pre>${incident.programActivity.programActivityDesc}</pre></td>
				</tr>
</c:forEach>	        
	        </tbody>
        </table>
        </div>
    </div>
    </div>
    <div class="form-container col-md-12 col-lg-12 noprint padding-md">
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/incident/create';">Create New Incident Report</button>
    </div>


