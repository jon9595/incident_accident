<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="${pageContext.request.contextPath}/css/checkbox-radio.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"/ >
<script src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mizrec.js"></script>
<script src="${pageContext.request.contextPath}/js/mask/jquery.mask.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
    $('#date').datetimepicker({
      timepicker:false,
      scrollInput:false,
      format:'m/d/Y'
    });

    $('#dob').datetimepicker({
      timepicker:false,
      scrollInput:false,
      format:'m/d/Y'
    });

    $('#time').datetimepicker({
      datepicker:false,
      format:'H:i'
    }); 
    setcheckboxes();
    setcheckboxstate();
    $('.phone').mask('000-000-0000');
  });
</script>
<jsp:include page=""/>

<div class="container-fluid" id="content">
    <div class="page-header padding-top-xl">
      <h1>Accident Report</h1>
    </div>
    <div class="row">
        <div class="col-md-12 col-lg-12">
              <html:form method="post" modelAttribute="accidentForm" action="${pageContext.request.contextPath}/accident/create" class="form-horizontal" >
              <jsp:include page="/WEB-INF/jsp/modules/demographics.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/membership-status.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/program-activity.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/locations.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/injury-locations.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/accident-details.jsp"/>
              <jsp:include page="/WEB-INF/jsp/modules/accident-accounts.jsp"/>
				<div class="form-container padding-bottom-none">
	                <div class="form-group">
	                  <div class="col-sm-11 col-md-5 col-lg-3 pull-right margin-bottom-lg">
	                    <input type="submit" class="btn btn-large padding-left-xl padding-right-xl" value="Submit Changes">
	                  </div>
					</div>
				</div>              
              </html:form>
        </div>
    </div>
</div>