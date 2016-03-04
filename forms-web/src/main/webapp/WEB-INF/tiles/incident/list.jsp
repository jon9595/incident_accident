<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<link href="${pageContext.request.contextPath}/css/displaytag.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/mask/jquery.mask.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"/ >
<script src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mizrec.js"></script>
<script>
	$(document).ready(function(){
		$('.date').mask('00/00/0000');
		$('#content').removeClass("container");
		$('#content').addClass("container-fluid");
	    $('.table-hover > tbody > tr').click(function(){
	    	var id = $(this).find('td:first').text();
	    	location.href= '${pageContext.request.contextPath}/incident/view/'+id;
	    });
		$('#accordion').on('hidden.bs.collapse', toggleChevron);
		$('#accordion').on('shown.bs.collapse', toggleChevron);	
		$('h4.panel-title').click(function(){
			$('#searchIncidentsAccordian').collapse('toggle');
		});
		$('#btnDelSel').click(function(){
			var sel = getSelected();
			if(sel.length == 0) {
				alert("You must select at least one to delete.");
			} else {
				if(confirm('Are you sure you want to delete the selected reports?')){
					var str = "";
					for(var i = 0; i < sel.length; i++) {
						str += "&id="+sel[i];
					}
					location.href= '${pageContext.request.contextPath}/incident/deleteMult?'+str;
				}
			}
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

	function getSelected(){
		var sel = [];
		$('.chkbox > input[type="checkbox"]').each(function(){
			if($(this).prop('checked')) {
				sel.push($(this).parent().parent().find('td:first').text());
			}
		});
		return sel;
	}
	
	
	
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
		$('#btnDelSel').removeClass('hidden');
		$('#btnSelMult').addClass('hidden');
		$('#btnSelSingle').removeClass('hidden');
	}

	function selectSingle() {
		check(false);
		$('.allbox').addClass('hidden');
		$('.chkbox').each(function(){
			$(this).addClass('hidden');
		});
		$('.table-hover > tbody > tr').unbind('click');
	    $('.table-hover > tbody > tr').click(function(){
	    	var id = $(this).find('td:first').text();
	    	location.href= '${pageContext.request.contextPath}/incident/view/'+id;
	    });
		$('#btnSelSingle').addClass('hidden');
		$('#btnSelMult').removeClass('hidden');
		$('#btnDelSel').addClass('hidden');
	}	
	
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
	                <h4 class="panel-title" style="cursor:pointer;">
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
			pagesize="5"
			sort="list"
			requestURI=""
			class="table table-hover table-striped">
			<display:column property="id" headerClass="hidden" class="hidden"></display:column>
			<display:column headerClass="hidden allbox" class="hidden chkbox" title="${checkAll}">
			<input type="checkbox" />
			</display:column>
			<display:column title="Date/Time" sortable="true" sortProperty="incidentDate">
				<fmt:formatDate value="${incident.incidentDate}" pattern="MM/dd/yyyy"/><br/><fmt:formatDate value="${incident.incidentDate}" pattern="hh:mm a"/>
			</display:column>
			<display:column title="Name/Address" sortable="true" sortProperty="revName">
				${incident.name}<br/>${incident.address}
			</display:column>
			<display:column title="Membership Status" property="membershipStatus.membershipStatus" sortable="true"/>
			<display:column title="Incident Details" sortable="true">
				<pre>${incident.incidentDetails}</pre>
			</display:column>
			<display:column title="Location" sortable="true">
				<pre>${incident.location}</pre>
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
        <button class="btn btn-primary" onclick="selectRows();" id="btnSelMult">Select Multiple</button>
        <button class="btn btn-primary hidden" onclick="selectSingle();" id="btnSelSingle">Select Single</button>
        <button class="btn btn-primary hidden pull-right" id="btnDelSel">Delete Selected</button>
    </div>


