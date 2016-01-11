<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/mask/jquery.mask.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"/ >
<script src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mizrec.js"></script>
<script>
$(document).ready(function(){
	 $('.date').mask('00/00/0000');
	 $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
	     var href = e.target['href'];
	     if(href.indexOf('#searchIncidentTab') >= 0) {
	    	 $('#incident_name').focus();
	     } else {
	    	 $('#accident_name').focus();
	     }
	 })				 
				 
});
</script>
    <div class="form-container color-black">
    	<fieldset>
    	<legend>Reports Needing Approval</legend>
	    <div class="row">
	    <div class="col-md-6">
	    <h3>Incident Reports</h3>
	    <ul>
	    <c:choose>
	    	<c:when test="${empty incidents}">
	    	None
	    	</c:when>
	    	<c:otherwise>
	    <c:forEach items="${incidents}" var="incident">
	    	<li><a href="${pageContext.request.contextPath}/incident/view/${incident.id}"><fmt:formatDate value="${incident.demographics.date}" pattern="MM/dd/yyyy"/> - ${incident.demographics.name} - ${incident.incidentDetailsDesc}</a></li>
	    </c:forEach>
	    	</c:otherwise> 
	    </c:choose>
	    </ul>
	    </div>
	    <div class="col-md-6">
	    <h3>Accident Reports</h3>
	    <ul>
	    <c:forEach items="${accidents}" var="accident">
	    	<li><a href="${pageContext.request.contextPath}/accident/view/${accident.id}"><fmt:formatDate value="${accident.demographics.date}" pattern="MM/dd/yyyy"/> - ${accident.demographics.name} - ${accident.accidentDetailsDesc}</a></li>
	    </c:forEach>
	    </ul>
	    </div>
	    </div>
    	</fieldset>
    </div>
    <div class="form-container color-black">
 	<ul class="nav nav-tabs" role="tablist">
	    <li role="presentation" class="active"><a href="#searchIncidentTab" aria-controls="searchIncidentTab" role="tab" data-toggle="tab">Search Incident Reports</a></li>
	    <li role="presentation"><a href="#searchAccidentTab" aria-controls="searchAccidentTab" role="tab" data-toggle="tab">Search Accident Reports</a></li>
  	</ul>

	<!-- Tab panes -->
	<div class="tab-content padding-top-lg">
		<div role="tabpanel" class="tab-pane active" id="searchIncidentTab">
              <jsp:include page="/WEB-INF/jsp/modules/search-incidents.jsp"/>
		</div>
		<div role="tabpanel" class="tab-pane" id="searchAccidentTab">
              <jsp:include page="/WEB-INF/jsp/modules/search-accidents.jsp"/>
		</div>
	</div>	
	</div>

