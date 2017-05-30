<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="row margin-left-sm margin-right-sm">
	<div class="col-md-12">
		<fieldset><legend>Update Email Notifications</legend>
		
			<c:forEach items="${emails}" var="email">
				<c:if test="${email.area == 'events'}">
					<html:form>
						<div class="form-container padding-bottom-none">
							Name: ${}
						</div> 
					</html:form>
				</c:if>
			</c:forEach>
		
			<html:form method="post" modelAttribute="emailForm" action="${pageContext.request.contextPath}/users/updateEmail" class="form-vertical color-black" >
				<div class="form-container padding-bottom-none">
					<label for="userId">
					Select a User to add to an area:
						<select id="userId" name="userId">
							<c:forEach items="${users}" var="user">
								<option value="${user.id}">${user.firstName}&nbsp;${user.lastName}</option>
							</c:forEach>
						</select>
					</label>
					<label for="email-area">
						<select id="email-area" name="area">
							<option value="events">Events</option>
							<option value="clubsports">Club Sports</option>
							<option value="facilities">Facilities</option>
							<option value="recsports">RecSports</option>
							<option value="aquatics">Aquatics</option>
						</select>
					</label>
				</div>
				<div class="display-container" style="padding-top:10px; padding-bottom:10px;">
					<input type="submit" class="btn btn-large btn-primary padding-left-xl padding-right-xl" value="Add User To Email List">
				</div>
			</html:form>
		</fieldset>
	</div>
</div>
