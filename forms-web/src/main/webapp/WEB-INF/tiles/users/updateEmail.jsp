<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(document).ready(function(){
	$('#username').focus();
});
</script>

<html:form method="post" modelAttribute="usersForm" action="${pageContext.request.contextPath}/users/create" class="form-vertical color-black" >
<div class="form-container padding-bottom-none">
    <fieldset><legend>Create New User</legend>
          <div class="row margin-left-sm margin-right-sm">
			  <div class="col-md-12">
			        <div class="margin-bottom-sm">
				        <div class="form-group margin-right-sm">
				           <label for="username" class="col-md-3 padding-left-none">Username: </label>
				           <html:input path="username" cssClass="form-control"/>
				            <span style="color: red;"><html:errors path="username" cssClass="err" /></span>
				         </div>
			        </div>
			        <div class="margin-bottom-sm">
			        <div class="form-group margin-right-sm">
			           <label for="email" class="col-md-3 padding-left-none">Email Address: </label>
			           <html:input path="email" cssClass="form-control"/>
			            <span style="color: red;"><html:errors path="email" cssClass="err" /></span>
			         </div>
			        </div>
			        <div class="margin-bottom-sm">
				        <div class="form-group margin-right-sm">
				           <label for="firstName" class="col-md-3 padding-left-none">First Name: </label>
				           <html:input path="firstName" cssClass="form-control"/>
				            <span style="color: red;"><html:errors path="firstName" cssClass="err" /></span>
				         </div>
			        </div>
			        <div class="margin-bottom-sm">
			        <div class="form-group margin-right-sm">
			           <label for="lastName" class="col-md-3 padding-left-none">Last Name: </label>
			           <html:input path="lastName" cssClass="form-control"/>
			            <span style="color: red;"><html:errors path="lastName" cssClass="err" /></span>
			         </div>
			        </div>
			        <div class="margin-bottom-sm">
			         <div class="form-group margin-right-sm">
			            <label for="password" class="col-md-3 padding-left-none">Position: </label>
			            <html:input type="text" path="position" cssClass="form-control"/>
			            <span style="color: red;"><html:errors path="position" cssClass="err" /></span>
			         </div>
			        </div>
			        <div class="margin-bottom-sm">
			         <div class="form-group margin-right-sm">
			            <label for="password" class="col-md-3 padding-left-none">Password: </label>
			            <html:password path="password" cssClass="form-control"/>
			            <span style="color: red;"><html:errors path="password" cssClass="err" /></span>
			         </div>
			        </div>
			        <div class="margin-bottom-sm">
			         <div class="form-group margin-right-sm">
			            <label for="password2" class="col-md-3 padding-left-none">Confirm Password: </label>
			            <html:password path="password2" cssClass="form-control"/>
			            <span style="color: red;"><html:errors path="password2" cssClass="err" /></span>
			         </div>
			        </div>
	     </div>
    </fieldset>
</div>
<div class="display-container" style="padding-top:10px; padding-bottom:10px;">
	<input type="submit" class="btn btn-large btn-primary padding-left-xl padding-right-xl" value="Create User">
</div>
</html:form>