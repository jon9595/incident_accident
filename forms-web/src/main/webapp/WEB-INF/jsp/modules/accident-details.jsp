<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <div class="form-container padding-bottom-none">
                <fieldset><legend>Accident Details</legend>
						<div class="form-group">
							<div class="col-md-12 columns">
<c:forEach items="${accidentDetailDesc}" var="detail">
								<label class="checkbox-inline" for="ad-${detail.id}">
						            <html:checkbox path="accidentDetails" id="ad-${detail.id}" value="${detail.id}"/>
						            ${detail.description}
						            </label> 
</c:forEach>
							</div>
						</div>
				</fieldset>
			</div>
