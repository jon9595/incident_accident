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
	    	location.href= '${pageContext.request.contextPath}/accident/view/'+id;
	    });
		$('#accordion').on('hidden.bs.collapse', toggleChevron);
		$('#accordion').on('shown.bs.collapse', toggleChevron);	
		$('h4.panel-title').click(function(){
			$('#searchAccidentsAccordian').collapse('toggle');
		});
		
		$('.chkbox > input[type="checkbox"]').each(function(){
			$(this).change(function(){
				if($(this).prop('checked')) {
					$(this).parent().parent().addClass('row-hover');
				} else {
					$(this).parent().parent().removeClass('row-hover');
				}
			});			
		});

	});
	
	function check(ischecked) {
		$('.chkbox > input[type="checkbox"]').each(function(){
			$(this).prop('checked', ischecked);
			$(this).change();
		});
	}
	
	function selectRows() {
		$('.allbox').removeClass('hidden');
		$('.chkbox').each(function(){
			$(this).removeClass('hidden');
		});
		$('.table-hover > tbody > tr').unbind('click');
		$('.table-hover > tbody > tr').click(function(){
			if(!$(this).find('input:checkbox:first').prop('checked')) {
				$(this).find('input:checkbox:first').prop('checked', true);
				$(this).find('input:checkbox:first').change();
			} else {
				$(this).find('input:checkbox:first').prop('checked', false);
				$(this).find('input:checkbox:first').change();
			}
	    });
	}

	function toggleChevron(e) {
	    $(e.target)
	        .prev('.panel-heading')
	        .find('i.indicator')
	        .toggleClass('glyphicon-chevron-down glyphicon-chevron-right');
	}
</script>
    <div class="page-header padding-top-xl">
      <h1>Accident Reports</h1>
    </div>
    <div class="form-container margin-none padding-none">
	    <div class="panel-group color-black" id="accordion">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	                <h4 class="panel-title" style="cursor:pointer;">
	                    <a data-toggle="collapse" data-parent="#accordion" href="#searchAccidentsAccordian" aria-expanded="false" class="collapsed"><i class="fa fa-search fa-fw"></i>&nbsp;Search Accident Forms</a>
						<i class="indicator glyphicon  pull-right glyphicon-chevron-right"></i>
	                </h4>
	            </div>
	            <div id="searchAccidentsAccordian" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
	                <div class="panel-body">
              <jsp:include page="/WEB-INF/jsp/modules/search-accidents.jsp"/>    
	                </div>
	            </div>
	        </div>
	    </div>    
    </div>
    <div class="form-container padding-bottom-none">
    <div class="row">
        <div class="col-md-12 col-lg-12 table-responsive color-black">
			<display:table 
			name="${accidents}"
			id="accident"
			pagesize="5"
			sort="list"
			requestURI=""
			class="table table-hover table-striped">
			<display:column property="id" headerClass="hidden" class="hidden"></display:column>
			<display:column headerClass="hidden allbox" class="hidden chkbox" title="${checkAll}">
			<input type="checkbox" />
			</display:column>
			<display:column sortable="true" sortProperty="accidentDate" title="Date/Time">
			<fmt:formatDate value="${accident.accidentDate}" pattern="MM/dd/yyyy"/><br/><fmt:formatDate value="${accident.accidentDate}" pattern="hh:mm a"/>
			</display:column>
			<display:column title="Name/Address" sortable="true" sortProperty="revName">
			${accident.name}<br/>${accident.address}
			</display:column>
			<display:column property="membershipStatus.membershipStatus" title="Membership Status" sortable="true"></display:column>
			<display:column title="Location">
			<pre>${accident.location}</pre>
			</display:column>
			<display:column title="Program Involved">
			<pre>${accident.programActivity.programActivityDesc}</pre>
			</display:column>
			<display:column title="Injury Location">
			<pre>${accident.injuryLocation}</pre>
			</display:column>
			<display:column property="emsContacted" title="EMS Contacted"></display:column>
			</display:table>
        </div>
    </div>
    </div>
    <div class="form-container col-md-12 col-lg-12 noprint padding-md">
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/accident/create';">Create New Accident Report</button>
        <button class="btn btn-primary" onclick="selectRows();">Select Multiple</button>
    </div>


