<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="${pageContext.request.contextPath}/css/checkbox-radio.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"/ >
<script src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mizrec.js"></script>
<script src="${pageContext.request.contextPath}/js/mask/jquery.mask.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
    $('.date').datetimepicker({
      timepicker:false,
      scrollInput:false,
      format:'m/d/Y'
    });

    $('.time').datetimepicker({
        datepicker:false,
        format:'H:i'
      }); 
    
    setcheckboxes();
    setcheckboxstate();
    $('.phone').mask('000-000-0000');
    $('.date').mask('00/00/0000');
    $('.time').mask('00:00');
    $('.date').attr('autocomplete', 'off');
    $('.time').attr('autocomplete', 'off');
    $('.injury-chkbox').click(function(){
    	if($(this).is(':checked')){
    		$(this).next().removeClass('hidden');
    	} else {
    		$(this).next().addClass('hidden');
    	}
    });
  });
</script>

<div class="container-fluid" id="content">
    <div class="page-header padding-top-xl">
      <h1>Accident Report</h1>
    </div>
    <div class="row">
        <div class="col-md-12 col-lg-12">
              <html:form method="post" modelAttribute="accidentForm" action="${pageContext.request.contextPath}/accident/edit" class="form-horizontal" >
              <html:hidden path="id"/>
              <jsp:include page="/WEB-INF/jsp/modules/demographics.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/membership-status.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/program-activity.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/locations.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/injury-locations.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/accident-details.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/accident-accounts.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/refusal-of-care.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/accident-witness.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/proper-notifications.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/report-completion.jsp"/>
              <%--
			    <div class="col-md-12 col-lg-12">
			        <div class="display-container" style="padding-top:10px; padding-bottom:10px;">
						<input type="submit" class="btn btn-large padding-left-xl padding-right-xl" value="Save Report">
			        </div>
			    </div>
               --%>
              </html:form>
        </div>
    </div>
</div>