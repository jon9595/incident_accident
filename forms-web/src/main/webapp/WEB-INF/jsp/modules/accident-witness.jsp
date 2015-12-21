<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(document).ready(function(){
<c:if test="${accidentForm.witnessOne.sigId == 0 || accidentForm.witnessOne.sigId == '' || accidentForm.witnessOne.sigId == null}">
	var witOneSig = $('#witOneSignature').val();
	var witOne = $('#witOneCanvas').signaturePad({drawOnly:true, lineTop:80, validateFields:false});
	if(witOneSig != '') {
		witOne.regenerate(witOneSig);
	}
	$('#witOneClear').click(function(){
		witOne.clearCanvas();
	});
</c:if>
<c:if test="${accidentForm.witnessTwo.sigId == 0 || accidentForm.witnessTwo.sigId == '' || accidentForm.witnessTwo.sigId == null}">
	var witTwoSig = $('#witTwoSignature').val();
	var witTwo = $('#witTwoCanvas').signaturePad({drawOnly:true, lineTop:80, validateFields:false});
	if(witTwoSig != '') {
		witTwo.regenerate(witTwoSig);
	}
	$('#witTwoClear').click(function(){
		witTwo.clearCanvas();
	});
</c:if>
});
</script>
<html:hidden path="witnessOne.sigId"/>
<html:hidden path="witnessTwo.sigId"/>
    <div class="form-container padding-bottom-none">
        <fieldset><legend>Witness Information</legend>
          <div class="row margin-left-sm margin-right-sm">
			  <div class="col-md-12">
		          	<div class="form-group">
			          	<div class="col-md-8">
<c:choose>
	<c:when test="${accidentForm.witnessOne.sigId == 0 || accidentForm.witnessOne.sigId == '' || accidentForm.witnessOne.sigId == null}">			          	
			          		<label for="witnessOne.name" class="col-md-12">
			          		Witness Name:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="witnessOne.name" id="witnessOne.name" class="form-control" type="text"/>
			          		</div>
	</c:when>
	<c:otherwise>
							<label>Witness Name: </label>
							${accidentForm.witnessOne.name}
	</c:otherwise>
</c:choose>
			          	</div>
			          	<div class="col-md-4">
<c:choose>
	<c:when test="${accidentForm.witnessOne.sigId == 0 || accidentForm.witnessOne.sigId == '' || accidentForm.witnessOne.sigId == null}">			          	
			          		<label for="witnessOne.phone" class="col-md-12">
			          		Phone:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="witnessOne.phone" id="witnessOne.phone" class="form-control phone" type="text"/>
	              			<span style="color: red;"><html:errors path="witnessOne.phone" cssClass="err" /></span>                
			          		</div>
	</c:when>
	<c:otherwise>
							<label>Phone: </label>
							${accidentForm.witnessOne.phone}
	</c:otherwise>
</c:choose>
			          	</div>
		          	</div>
	          </div>
	          <div class="col-md-12 margin-left-md">
		          	<div class="form-group">
		          		<div class="col-md-6 sigPad margin-right-xl margin-left-md" id="witOneCanvas">
<c:choose>
	<c:when test="${accidentForm.witnessOne.sigId == 0 || accidentForm.witnessOne.sigId == '' || accidentForm.witnessOne.sigId == null}">
							<label for="witnessOneSignature" class="col-md-12">
							Witness Signature:   &nbsp;&nbsp;<span id="witOneClear" class="sigClear">Clear</span>
							</label>
							<div class="sig sigWrapper">
							<canvas class="pad" width="458" height="85" id="witnessOneSignature"></canvas>
							<html:hidden path="witnessOne.signature" class="output" id="witOneSignature"/>
							<span style="color: red;"><html:errors path="witnessOne.signature" cssClass="err" /></span>
							</div>
	</c:when>
	<c:otherwise>
							<img alt="Witness Signature" src="${pageContext.request.contextPath}/regenSignature/${accidentForm.witnessOne.sigId}">
	</c:otherwise>
</c:choose>
		          		</div>
		          	</div>
	          </div>
		  </div>
		  <br/><br/>
          <div class="row margin-left-sm margin-right-sm">
			  <div class="col-md-12">
		          	<div class="form-group">
			          	<div class="col-md-8">
<c:choose>
	<c:when test="${accidentForm.witnessTwo.sigId == 0 || accidentForm.witnessTwo.sigId == '' || accidentForm.witnessTwo.sigId == null}">
			          		<label for="witnessTwo.name" class="col-md-12">
			          		Witness Name:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="witnessTwo.name" id="witnessTwo.name" class="form-control" type="text"/>
			          		</div>
	</c:when>
	<c:otherwise>
							<label>Witness Name: </label>
							${accidentForm.witnessTwo.name}
	</c:otherwise>
</c:choose>
			          	</div>
			          	<div class="col-md-4">
<c:choose>
	<c:when test="${accidentForm.witnessTwo.sigId == 0 || accidentForm.witnessTwo.sigId == '' || accidentForm.witnessTwo.sigId == null}">
			          		<label for="witnessTwo.phone" class="col-md-12">
			          		Phone:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="witnessTwo.phone" id="witnessTwo.phone" class="form-control phone" type="text"/>
	              		    <span style="color: red;"><html:errors path="witnessTwo.phone" cssClass="err" /></span>                
			          		</div>
	</c:when>
	<c:otherwise>
							<label>Witness Phone: </label>
							${accidentForm.witnessTwo.phone}
	</c:otherwise>
</c:choose>
			          	</div>
		          	</div>
	          </div>
	          <div class="col-md-12 margin-left-md">
		          	<div class="form-group">
		          		<div class="col-md-6 sigPad margin-right-xl margin-left-md" id="witTwoCanvas">
<c:choose>
	<c:when test="${accidentForm.witnessTwo.sigId == 0 || accidentForm.witnessTwo.sigId == '' || accidentForm.witnessTwo.sigId == null}">
			          		<label for="witnessTwo.signature" class="col-md-12">
							Witness Signature:   &nbsp;&nbsp;<span id="witTwoClear" class="sigClear">Clear</span>
			          		</label>
							<div class="sig sigWrapper">
							<canvas class="pad" width="458" height="85" id="witnessTwoSignature"></canvas>
							<html:hidden path="witnessTwo.signature" class="output" id="witTwoSignature"/>
							<span style="color: red;"><html:errors path="witnessTwo.signature" cssClass="err" /></span>
							</div>
	</c:when>
	<c:otherwise>
							<img alt="Witness Signature" src="${pageContext.request.contextPath}/regenSignature/${accidentForm.witnessTwo.sigId}">
	</c:otherwise>
</c:choose>
		          		</div>
		          	</div>
	          </div>
		  </div>
        </fieldset>
    </div>
