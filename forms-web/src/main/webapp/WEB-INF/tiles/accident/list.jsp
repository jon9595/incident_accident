<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<link href="${pageContext.request.contextPath}/css/displaytag.css" rel="stylesheet">
<script>
	$(document).ready(function(){
		$('#content').removeClass("container");
		$('#content').addClass("container-fluid");
	    $('.table-hover > tbody > tr').click(function(){
	    	var id = $(this).find('td:first').text();
	    	location.href= '${pageContext.request.contextPath}/accident/view/'+id;
	    });
	});
</script>
    <div class="page-header padding-top-xl">
      <h1>Accident Reports</h1>
    </div>
    <div class="form-container padding-bottom-none">
    <div class="row">
        <div class="col-md-12 col-lg-12 table-responsive">
			<display:table 
			name="${accidents}"
			id="accident"
			pagesize="25"
			sort="list"
			requestURI=""
			class="table table-hover table-striped">
			<display:column property="id" headerClass="hidden" class="hidden"></display:column>
			<display:column sortable="true" sortProperty="demographics.date" title="Date/Time">
			<fmt:formatDate value="${accident.demographics.date}" pattern="MM/dd/yyyy"/><br/><fmt:formatDate value="${accident.demographics.time}" pattern="hh:mm a"/>
			</display:column>
			<display:column title="Name/Address" sortable="true" sortProperty="demographics.revName">
			${accident.demographics.name}<br/>${accident.demographics.address}
			</display:column>
			<display:column property="membershipStatus.membershipStatus" title="Membership Status" sortable="true"></display:column>
			<display:column title="Location">
			<pre>${accident.accidentLocationDesc}</pre>
			</display:column>
			<display:column title="Program Involved">
			<pre>${accident.programActivity.programActivityDesc}</pre>
			</display:column>
			<display:column title="Injury Location">
			<pre>${accident.injuryLocationsDesc}</pre>
			</display:column>
			<display:column property="emsContacted" title="EMS Contacted"></display:column>
			</display:table>
        </div>
    </div>
    </div>
    <div class="form-container col-md-12 col-lg-12 noprint padding-md">
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/accident/create';">Create New Accident Report</button>
    </div>


