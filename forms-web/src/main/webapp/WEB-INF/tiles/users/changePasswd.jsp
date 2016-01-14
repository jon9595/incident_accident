<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(document).ready(function(){
	$('#oldPassword').focus();
});
</script>
    <html:form method="post" modelAttribute="usersForm" action="${pageContext.request.contextPath}/users/changePasswd" class="form-horizontal" >
    <html:hidden path="id"/>
    <html:hidden path="username"/>
<div class="form-container padding-bottom-none">
    <fieldset><legend>User Information</legend>
          <div class="row margin-left-sm margin-right-sm">
			  <div class="col-md-12 padding-top-md padding-bottom-lg padding-left-none">
		        	<label class="input-control">Username: </label>
					${usersForm.username}
			  </div>
			  <div class="col-md-12">
			        <div class="margin-bottom-sm">
			          	<div class="form-group">
					        	<label for="oldPassword">Current Password: </label>
					         		<html:input path="oldPassword" id="oldPassword" class="form-control margin-bottom-md" type="password"/>
									<span style="color: red;"><html:errors path="oldPassword" cssClass="err" /></span>                
				        </div>
			        </div>
			        <div class="margin-bottom-sm">
			          	<div class="form-group">
					        	<label for="password">New Password: </label>
					         		<html:input path="password" id="password" class="form-control margin-bottom-md" type="password"/>
									<span style="color: red;"><html:errors path="password" cssClass="err" /></span>                
						</div>
        			</div>
			        <div class="margin-bottom-sm">
			          	<div class="form-group">
					        	<label for="password2">New Password Again: </label>
					         		<html:input path="password2" id="password2" class="form-control margin-bottom-md" type="password"/>
									<span style="color: red;"><html:errors path="password2" cssClass="err" /></span>                
						</div>
        			</div>
		      </div>
		  </div>
	</fieldset>
</div>
<div class="display-container" style="padding-top:10px; padding-bottom:10px;">
	<input type="submit" class="btn btn-large btn-primary padding-left-xl padding-right-xl" value="Save Changes">
</div>
</html:form>
			  