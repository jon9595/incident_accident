<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <script>
    $(document).ready(function() {
<c:if test="${accidentForm.refusalOfCare.memberSig == 0 || accidentForm.refusalOfCare.memberSig == ''}">
		var mbrSig = $('#refusalOfCareMemberSignature').val();
		var stfSig = $('#refusalOfCareStaffSignature').val();
		var mbr = $('#memberCanvas').signaturePad({drawOnly:true, lineTop:80, validateFields:false});
		var sft = $('#staffCanvas').signaturePad({drawOnly:true, lineTop:80, validateFields:false});
		
		if(mbrSig != '') {
			mbr.regenerate(mbrSig);
		}
		
		if(stfSig != '') {
			sft.regenerate(stfSig);
		}
		
		$('#spnMbr').click(function(){
			mbr.clearCanvas();
		});
		$('#staffMbr').click(function(){
			sft.clearCanvas();
		});
</c:if>    	
    });
  </script>
    <html:hidden path="refusalOfCare.memberSig"/>
    <html:hidden path="refusalOfCare.staffSig"/>
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
<c:choose>
<c:when test="${accidentForm.refusalOfCare.memberSig != 0}">
				<label for="refusalCare">
				Member Signature:  &nbsp;&nbsp;
				</label>
					<img src="${pageContext.request.contextPath}/regenSignature/${accidentForm.refusalOfCare.memberSig}"/>
</c:when>
<c:otherwise>
				<label for="refusalCare">
				Member Signature:  &nbsp;&nbsp;<span id="spnMbr" class="sigClear">Clear</span>
				</label>
					<div class="sig sigWrapper">
					<canvas class="pad" width="458" height="85" id="refusalCare"></canvas>
					<html:hidden path="refusalOfCare.memberSignature" class="output" id="refusalOfCareMemberSignature"/>
					</div>
</c:otherwise>
</c:choose>
          		</div>
				<div class="col-md-6 sigPad" id="staffCanvas">
<c:choose>
<c:when test="${accidentForm.refusalOfCare.staffSig != 0}">
					<label for="staffSig">
					Staff Signature:   &nbsp;&nbsp;
					</label>
					<img src="${pageContext.request.contextPath}/regenSignature/${accidentForm.refusalOfCare.staffSig}"/>
</c:when>
<c:otherwise>
					<label for="staffSig">
					Staff Signature:   &nbsp;&nbsp;<span id="staffMbr" class="sigClear">Clear</span>
					</label>
					<div class="sig sigWrapper">
					<canvas class="pad" width="458" height="85" id="staffSig"></canvas>
					<html:hidden path="refusalOfCare.staffSignature" class="output" id="refusalOfCareStaffSignature"/>
					<span style="color: red;"><html:errors path="refusalOfCare.staffSignature" cssClass="err" /></span>
					</div>
</c:otherwise>
</c:choose>
				</div>
          	</div>
          </div>
   		<div class="col-md-3">
   		<div class="form-group">
			<label for="memberRefusalDate">
			Date:
			</label>
<c:choose>
<c:when test="${accidentForm.refusalOfCare.memberSig != 0}">
			<label>${accidentForm.refusalOfCare.dateStr}</label>
</c:when>
<c:otherwise>
			<html:input type="text" path="refusalOfCare.dateStr" class="form-control col-md-3 margin-bottom-md date" id="memberRefusalDate"/>
   			<span style="color: red;"><html:errors path="refusalOfCare.dateStr" cssClass="err" /></span>
</c:otherwise>
</c:choose>
   		</div>
		</div>
          
          </div>
        </fieldset>
	</div>
