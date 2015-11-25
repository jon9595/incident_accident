<link href="${pageContext.request.contextPath}/css/checkbox-radio.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"/ >
<script src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mizrec.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
    $('#date').datetimepicker({
      timepicker:false,
      format:'m/d/Y'
    });

    $('#dob').datetimepicker({
      timepicker:false,
      format:'m/d/Y'
    });

    $('#time').datetimepicker({
      datepicker:false,
      format:'H:i'
    }); 
    setcheckboxes();
   
  });
</script>
<<jsp:include page=""/>

<div class="container-fluid" id="content">
    <div class="page-header padding-top-xl">
      <h1>Accident Report</h1>
    </div>
    <div class="row">
        <div class="col-md-12 col-lg-12">
              <form class="form-horizontal">
              <jsp:include page="/WEB-INF/jsp/modules/demographics.jsp"/>

              <jsp:include page="/WEB-INF/jsp/modules/membership-status.jsp"/>

              </form>
        </div>
    </div>
</div>