<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <link href="${pageContext.request.contextPath}/js/signature-pad/jquery.signaturepad.css" rel="stylesheet">
 <!--[if lt IE 9]><script src="${pageContext.request.contextPath}/js/signature-pad/flashcanvas.js"></script><![endif]-->
 <script src="${pageContext.request.contextPath}/js/signature-pad/jquery.signaturepad.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/signature-pad/json2.min.js" type="text/javascript"></script>

 <script>
    $(document).ready(function() {
    	var mbr = $('#memberCanvas').signaturePad({drawOnly:true, lineTop:80});
    	var sft = $('#staffCanvas').signaturePad({drawOnly:true, lineTop:80});
    	$('#spnMbr').click(function(){
    		mbr.clearCanvas();
    	});
    });
  </script>
  
    <div class="form-container padding-bottom-none">
        <fieldset><legend>Refusal of Care <small class="text-muted">(If guest refuses medical care)</small></legend>
        <p class="text-muted">The staff of MizzouRec has informed the injured party that they have a suspected medical injury.  At this time, 
        the injured party has refused the care of MizzouRec personnel and decided to seek care on their own.  By signing, the injured party
        agrees to hold the University of Missouri and the staff of MizzouRec harmless from any further actions as a result of their suspected
        injury.  <u>The injured party understands that he or she must exit the facility and discontinue use of any MizzouRec facilities for 
        the remainder of the day.</u></p>
          <div class="row margin-left-sm margin-right-sm">
		  <div class="col-md-12">
          	<div class="form-group">
          		<div class="col-md-6 sigPad margin-right-xl" id="memberCanvas">
				<label for="refusalCare">
				Member Signature:  <span id="spnMbr">Clear</span>
				</label>
					<div class="sig sigWrapper">
					<canvas class="pad" width="458" height="85" id="refusalCare"></canvas>
					<html:hidden path="refusalOfCare.memberSignature" class="output"/>
					</div>
          		</div>
				<div class="col-md-6 sigPad" id="staffCanvas">
					<label for="staffSig">
					Staff Signature:
					</label>
					<div class="sig sigWrapper">
					<canvas class="pad" width="458" height="85" id="staffSig"></canvas>
					<html:hidden path="refusalOfCare.staffSignature" class="output"/>
					</div>
				</div>
          	</div>
          </div>
   		<div class="col-md-3">
   		<div class="form-group">
			<label for="memberRefusalDate">
			Date:
			</label>
			<html:input type="text" path="refusalOfCare.dateStr" class="form-control col-md-3 margin-bottom-md date" id="memberRefusalDate"/>
   		</div>
		</div>
          
          </div>
        </fieldset>
	</div>
