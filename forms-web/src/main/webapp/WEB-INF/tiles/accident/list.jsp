<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid" id="content">
    <div class="page-header padding-top-xl">
      <h1>Accident Report</h1>
    </div>
    <div class="row">
        <div class="col-md-12 col-lg-12 table-responsive">
        <table class="table table-hover table-bordered table-responsive">
	        <thead>
	        	<th>Date/Time</th>
	        	<th>Name</th>
	        	<th>Address</th>
	        	<th>Location</th>
	        	<th>Program Involved</th>
	        </thead>
	        <tbody>
<c:forEach items="${accidents}" var="accident">
				<tr>
					<td>${accident.demographics.dateTime}</td>
					<td>${accident.demographics.name}</td>
					<td>${accident.demographics.address}</td>
					<td></td>
					<td>${accident.programActivity.programActivityDesc}</td>
				</tr>
</c:forEach>	        
	        </tbody>
        </table>
        </div>
    </div>
</div>

