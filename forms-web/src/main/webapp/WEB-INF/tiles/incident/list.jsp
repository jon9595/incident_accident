<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<link href="${pageContext.request.contextPath}/css/displaytag.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"/ >
<script src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mizrec.js"></script>
<script>
	$(document).ready(function(){
		$('#content').removeClass("container");
		$('#content').addClass("container-fluid");
	    $('.table-hover > tbody > tr').click(function(){
	    	var id = $(this).find('td:first').text();
	    	location.href= '${pageContext.request.contextPath}/incident/view/'+id;
	    });
		$('#accordion').on('hidden.bs.collapse', toggleChevron);
		$('#accordion').on('shown.bs.collapse', toggleChevron);	
	});
	function toggleChevron(e) {
	    $(e.target)
	        .prev('.panel-heading')
	        .find('i.indicator')
	        .toggleClass('glyphicon-chevron-down glyphicon-chevron-right');
	}
</script>
    <div class="page-header padding-top-xl">
      <h1>Incident Reports</h1>
    </div>
    <div class="form-container margin-none padding-none">
	    <div class="panel-group color-black" id="accordion">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	                <h4 class="panel-title">
	                    <a data-toggle="collapse" data-parent="#accordion" href="#searchIncidentsAccordian" aria-expanded="false" class="collapsed"><i class="fa fa-search fa-fw"></i>&nbsp;Search Incident Forms</a>
						<i class="indicator glyphicon  pull-right glyphicon-chevron-right"></i>
	                </h4>
	            </div>
	            <div id="searchIncidentsAccordian" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
	                <div class="panel-body">
              <jsp:include page="/WEB-INF/jsp/modules/search-incidents.jsp"/>    
	                </div>
	            </div>
	        </div>
	    </div>    
    </div>
    <div class="form-container padding-bottom-none">
    <div class="row">
        <div class="col-md-12 col-lg-12 table-responsive color-black">
			<display:table 
			name="${incidents}"
			id="incident"
			pagesize="25"
			sort="list"
			requestURI=""
			class="table table-hover table-striped">
			<display:column property="id" headerClass="hidden" class="hidden"></display:column>
			<display:column title="Date/Time" sortable="true" sortProperty="demographics.date">
				<fmt:formatDate value="${incident.demographics.date}" pattern="MM/dd/yyyy"/><br/><fmt:formatDate value="${incident.demographics.time}" pattern="hh:mm a"/>
			</display:column>
			<display:column title="Name/Address" sortable="true" sortProperty="demographics.revName">
				${incident.demographics.name}<br/>${incident.demographics.address}
			</display:column>
			<display:column title="Membership Status" property="membershipStatus.membershipStatus" sortable="true"/>
			<display:column title="Incident Details" sortable="true">
				<pre>${incident.incidentDetailsDesc}</pre>
			</display:column>
			<display:column title="Location" sortable="true">
				<pre>${incident.incidentLocationDesc}</pre>
			</display:column>
			<display:column title="Program Involved">
				<pre>${incident.programActivity.programActivityDesc}</pre>
			</display:column>
			</display:table>
        </div>
    </div>
    </div>
    <div class="form-container col-md-12 col-lg-12 noprint padding-md">
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/incident/create';">Create New Incident Report</button>
    </div>


