<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <div class="form-container padding-bottom-none">
                <fieldset><legend>Incident Details</legend>
						<div class="form-group">
							<div class="col-md-12 columns">
<c:forEach items="${incidentDetailDesc}" var="detail">
								<label class="checkbox-inline" for="ad-${detail.id}">
						            <html:checkbox path="incidentDetails" id="ad-${detail.id}" value="${detail.id}"/>
						            ${detail.description}
						            </label> 
</c:forEach>
							</div>
						</div>
				</fieldset>
			</div>
