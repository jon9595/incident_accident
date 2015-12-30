<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script>
	$(document).ready(function(){
		$('#content').removeClass("container");
		$('#content').addClass("container-fluid");
	    $('.table-hover > tbody > tr').click(function(){
	    	var id = $(this).find('td:first').text();
	    	location.href= '${pageContext.request.contextPath}/users/view/'+id;
	    });
	});
</script>
<div class="page-header padding-top-xl">
  <h1>Users</h1>
</div>
    <div class="form-container padding-bottom-none">
    <div class="row">
        <div class="col-md-12 col-lg-12 table-responsive">
        <table class="table table-hover table-striped">
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

