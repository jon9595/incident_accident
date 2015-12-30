<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath}/css/checkbox-radio.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/mizrec.js"></script>
<script>
$(document).ready(function(){
    setcheckboxes();
    setcheckboxstate();
});
</script>

    <html:form method="post" modelAttribute="usersForm" action="${pageContext.request.contextPath}/users/edit" class="form-horizontal" >
    <html:hidden path="id"/>
    <html:hidden path="username"/>
<div class="form-container padding-bottom-none">
    <fieldset><legend>User Information</legend>
          <div class="row margin-left-sm margin-right-sm">
			  <div class="col-md-12">
		        	<label class="input-control">Username: </label>
					${usersForm.username}
			  </div>
			  <div class="col-md-12">
			        <div class="col-md-6 margin-bottom-sm">
			          	<div class="form-group">
					        	<label for="firstName">First Name: </label>
					         		<html:input path="firstName" id="firstName" class="form-control margin-bottom-md" type="text"/>
									<span style="color: red;"><html:errors path="firstName" cssClass="err" /></span>                
				        </div>
			        </div>
			        <div class="col-md-6 margin-bottom-sm">
			          	<div class="form-group">
					        	<label for="lastName">Last Name: </label>
					         		<html:input path="lastName" id="lastName" class="form-control margin-bottom-md" type="text"/>
									<span style="color: red;"><html:errors path="lastName" cssClass="err" /></span>                
						</div>
        			</div>
		      </div>
			  <div class="col-md-12">
			        <div class="col-md-6 margin-bottom-sm">
			          	<div class="form-group">
					        	<label for="email">Position:</label>
					         		<html:input path="position" id="email" class="form-control margin-bottom-md" type="text"/>
									<span style="color: red;"><html:errors path="position" cssClass="err" /></span>                
				        </div>
			        </div>
			        <div class="col-md-6 margin-bottom-sm">
			          	<div class="form-group">
					        	<label for="email">Email:</label>
					         		<html:input path="email" id="email" class="form-control email margin-bottom-md" type="text"/>
									<span style="color: red;"><html:errors path="email" cssClass="err" /></span>                
						</div>
        			</div>
		      </div>
			  <div class="col-md-12">
			  <h4>Roles</h4>
				  <div class="col-md-12 form-group">
                        <label class="checkbox-inline" for="role-admin">
                        <html:checkbox path="userRoles" id="role-admin" value="admin"/>
                        Admin
                        </label>
				  </div>
				  <div class="col-md-12 form-group">
                        <label class="checkbox-inline" for="role-manager">
                        <html:checkbox path="userRoles" id="role-manager" value="manager"/>
                        Manager
                        </label>
				  </div>
			  </div>
		  </div>
	</fieldset>
</div>
<div class="display-container" style="padding-top:10px; padding-bottom:10px;">
	<input type="submit" class="btn btn-large btn-primary padding-left-xl padding-right-xl" value="Save Changes">
</div>
</html:form>
