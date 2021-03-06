<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/s/bs/dt-1.10.10/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/s/bs/dt-1.10.10/datatables.min.js"></script>

<script>
	$(document).ready(function(){
		$('#content').removeClass("container");
		$('#content').addClass("container-fluid");
	    $('.table-hover > tbody > tr').click(function(){
	    	var id = $(this).find('td:first').text();
	    	location.href= '${pageContext.request.contextPath}/users/view/'+id;
	    });
	    $('#users').DataTable({
	    	"dom": "<'row margin-bottom-md'<'col-sm-6'p><'col-sm-6'f>>" +
	    	"<'row'<'col-sm-12'tr>>" +
	    	"<'row'<'col-sm-12'i>>",
	    	"pageLength": 10,
	    });
	});
</script>
<style type="text/css">
div.dataTables_wrapper div.dataTables_length label {
	color: #333;
}
div.dataTables_wrapper div.dataTables_filter label {
	color: #333;
}
ul.pagination {
	float: left !important;
}
</style>
<div class="page-header padding-top-xl">
  <h1>Users</h1>
</div>
    <div class="form-container padding-bottom-none">
    <div class="row">
        <div class="col-md-12 col-lg-12 table-responsive">
        <table class="table table-hover table-striped" id="users">
	        <thead>
	        	<th class="hidden"></th>
	        	<th>Username</th>
	        	<th>Name</th>
	        	<th>Email</th>
	        	<th>Last Logged In</th>
	        	<th>Position</th>
	        </thead>
	        <tbody>
<c:forEach items="${users}" var="user">
				<tr>
					<td class="hidden">${user.id}</td>
					<td>${user.username}</td>
					<td>${user.firstName}&nbsp;${user.lastName}</td>
					<td>${user.email}</td>
					<td align="left"><fmt:formatDate value="${user.lastLogin}" pattern="MM/dd/yyyy"/><br/><fmt:formatDate value="${user.lastLogin}" pattern="hh:mm a"/></td>
					<td>${user.position}</pre></td>
				</tr>
</c:forEach>	        
	        </tbody>
        </table>
        </div>
    </div>
    </div>
    <div class="form-container col-md-12 col-lg-12 noprint padding-md">
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/users/create';">Create New User</button>
    </div>

