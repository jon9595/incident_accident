<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
function deleteUser() {
	if(confirm("Are you sure you want to delete this user?")) {
		location.href='${pageContext.request.contextPath}/users/remove/${user.id}';
	}	
}

</script>

<div class="page-header padding-top-md noprint">
  <h1>User Profile - ${user.firstName}&nbsp;${user.lastName}</h1>
</div>
<div class="page-header margin-top-none margin-bottom-none padding-top-none padding-bottom-none noscreen">
  <h1>User Profile - ${user.firstName}&nbsp;${user.lastName}</h1>
</div>
    <div class="col-md-12 col-lg-12">
        <div class="display-container">
        <fieldset><legend>User Information</legend>
			<div class="row margin-bottom-lg">
				<div class="col-md-12">
			        <div class="col-md-6 margin-bottom-sm">
						<label>Username: </label>&nbsp;${user.username}
			        </div>
			        <div class="col-md-6 margin-bottom-sm">
						<label>Name: </label>&nbsp;${user.firstName}&nbsp;${user.lastName}
			        </div>
			    </div>
			</div>
			<div class="row margin-bottom-lg">
				<div class="col-md-12">
			        <div class="col-md-6 margin-bottom-sm">
						<label>Email: </label>&nbsp;${user.email}
			        </div>
			        <div class="col-md-6 margin-bottom-sm">
						<label>Postion: </label>&nbsp;${user.position}
			        </div>
				</div>
			</div>
			<div class="row margin-bottom-lg">
				<div class="col-md-12">
			        <div class="col-md-6 margin-bottom-sm">
						<label>Last Logged In: </label>&nbsp;<fmt:formatDate value="${user.lastLogin}" pattern="MM/dd/yyyy hh:mm a"/>
			        </div>
			        <div class="col-md-6 margin-bottom-sm">
						<label>User Added: </label>&nbsp;<fmt:formatDate value="${user.created}" pattern="MM/dd/yyyy hh:mm a"/>&nbsp;by&nbsp;${user.createdBy}
			        </div>
				</div>
			</div>
			<div class="row margin-bottom-lg">
				<div class="col-md-12">
				<h4>Roles</h4>
				<c:forEach items="${user.userRoles}" var="role">
				${role}<br/>
				</c:forEach>
				</div>
			</div>
        </fieldset>
        </div>
    </div>
    <c:if test="${sessionScope.userProfile.admin}">
    <div class="col-md-12 col-lg-12 noprint">
        <div class="display-container" style="padding-top:10px; padding-bottom:10px;">
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/users/edit/${user.id}';">Edit User</button>
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/users/changePasswd/${user.username}';">Change Password</button>
    <c:if test="${sessionScope.userProfile.username != user.username}">
        <button class="btn btn-primary" onclick="javascript:deleteUser();">Delete User</button>
    </c:if>    
        </div>
    </div>
    </c:if>

