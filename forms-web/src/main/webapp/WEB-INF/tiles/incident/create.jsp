<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="${pageContext.request.contextPath}/css/checkbox-radio.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"/ >
<script src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mizrec.js"></script>
 <link href="${pageContext.request.contextPath}/js/signature-pad/jquery.signaturepad.css" rel="stylesheet">
 <!--[if lt IE 9]><script src="${pageContext.request.contextPath}/js/signature-pad/flashcanvas.js"></script><![endif]-->
 <script src="${pageContext.request.contextPath}/js/signature-pad/jquery.signaturepad.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/signature-pad/json2.min.js" type="text/javascript"></script>
<script type="text/javascript">
  $(document).ready(function(){
    setupDateTimeObjects();
    setcheckboxes();
    setcheckboxstate();
    $('.phone').mask('000-000-0000');
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
      <h1>Incident Report</h1>
    </div>
    <div class="row">
        <div class="col-md-12 col-lg-12">
              <html:form method="post" modelAttribute="incidentForm" action="${pageContext.request.contextPath}/incident/create" class="form-horizontal" >
              <jsp:include page="/WEB-INF/jsp/modules/demographics.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/membership-status.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/program-activity.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/locations.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/incident-details.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/incident-accounts.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/incident-witness.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/proper-notifications.jsp"/>
				<div class="form-container padding-bottom-none">
	                <div class="form-group">
	                  <div class="col-sm-11 col-md-5 col-lg-3 pull-right margin-bottom-lg">
	                    <input type="submit" class="btn btn-large btn-primary padding-left-xl padding-right-xl" value="Save Report">
	                  </div>
					</div>
				</div>              
              </html:form>
        </div>
    </div>
</div>