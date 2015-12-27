<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(document).ready(function(){
<c:if test="${incidentForm.witnessInfo.sigId == 0 || incidentForm.witnessInfo.sigId == '' || incidentForm.witnessInfo.sigId == null}">
	var witOneSig = $('#witOneSignature').val();
	var witOne = $('#witOneCanvas').signaturePad({drawOnly:true, lineTop:80, validateFields:false});
	if(witOneSig != '') {
		witOne.regenerate(witOneSig);
	}
	$('#witOneClear').click(function(){
		witOne.clearCanvas();
	});
</c:if>
});
</script>
<html:hidden path="witnessInfo.sigId"/>
    <div class="form-container padding-bottom-none">
        <fieldset><legend>Witness Information</legend>
          <div class="row margin-left-sm margin-right-sm">
			  <div class="col-md-12">
		          	<div class="form-group">
			          	<div class="col-md-8">
<c:choose>
	<c:when test="${incidentForm.witnessInfo.sigId == 0 || incidentForm.witnessInfo.sigId == '' || incidentForm.witnessInfo.sigId == null}">			          	
			          		<label for="witnessInfo.name" class="col-md-12">
			          		Witness Name:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="witnessInfo.name" id="witnessInfo.name" class="form-control" type="text"/>
	              			<span style="color: red;"><html:errors path="witnessInfo.name" cssClass="err" /></span>                
			          		</div>
	</c:when>
	<c:otherwise>
							<label>Witness Name: </label>
							${incidentForm.witnessInfo.name}
	</c:otherwise>
</c:choose>
			          	</div>
			          	<div class="col-md-4">
<c:choose>
	<c:when test="${incidentForm.witnessInfo.sigId == 0 || incidentForm.witnessInfo.sigId == '' || incidentForm.witnessInfo.sigId == null}">			          	
			          		<label for="witnessInfo.phone" class="col-md-12">
			          		Phone:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="witnessInfo.phone" id="witnessInfo.phone" class="form-control phone" type="text"/>
	              			<span style="color: red;"><html:errors path="witnessInfo.phone" cssClass="err" /></span>                
			          		</div>
	</c:when>
	<c:otherwise>
							<label>Phone: </label>
							${incidentForm.witnessInfo.phone}
	</c:otherwise>
</c:choose>
			          	</div>
		          	</div>
	          </div>
	          <div class="col-md-12 margin-left-md">
		          	<div class="form-group">
		          		<div class="col-md-6 sigPad margin-right-xl margin-left-md" id="witOneCanvas">
<c:choose>
	<c:when test="${incidentForm.witnessInfo.sigId == 0 || incidentForm.witnessInfo.sigId == '' || incidentForm.witnessInfo.sigId == null}">
							<label for="witnessInfoSignature" class="col-md-12">
							Witness Signature:   &nbsp;&nbsp;<span id="witOneClear" class="sigClear">Clear</span>
							</label>
							<div class="sig sigWrapper">
							<canvas class="pad" width="458" height="85" id="witnessInfoSignature"></canvas>
							<html:hidden path="witnessInfo.signature" class="output" id="witOneSignature"/>
							<span style="color: red;"><html:errors path="witnessInfo.signature" cssClass="err" /></span>
							</div>
	</c:when>
	<c:otherwise>
							<img alt="Witness Signature" src="${pageContext.request.contextPath}/regenSignature/${incidentForm.witnessInfo.sigId}">
	</c:otherwise>
</c:choose>
		          		</div>
		          	</div>
	          </div>
		  </div>
        </fieldset>
    </div>
