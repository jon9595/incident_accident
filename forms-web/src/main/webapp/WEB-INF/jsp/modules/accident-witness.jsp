<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(document).ready(function(){
	var witOneSig = $('#witOneSignature').val();
	var witOne = $('#witOneCanvas').signaturePad({drawOnly:true, lineTop:80, validateFields:false});
	var witTwoSig = $('#witTwoSignature').val();
	var witTwo = $('#witTwoCanvas').signaturePad({drawOnly:true, lineTop:80, validateFields:false});
	if(witOneSig != '') {
		witOne.regenerate(witOneSig);
	}
	$('#witOneClear').click(function(){
		witOne.clearCanvas();
	});
	if(witTwoSig != '') {
		witTwo.regenerate(witTwoSig);
	}
	$('#witTwoClear').click(function(){
		witTwo.clearCanvas();
	});
	
});
</script>
<html:hidden path="witnessOne.signature"/>
<html:hidden path="witnessTwo.signature"/>
    <div class="form-container padding-bottom-none">
        <fieldset><legend>Witness Information</legend>
          <div class="row margin-left-sm margin-right-sm">
			  <div class="col-md-12">
		          	<div class="form-group">
			          	<div class="col-md-8">
			          		<label for="witnessOne.name" class="col-md-12">
			          		Witness Name:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="witnessOne.name" id="witnessOne.name" class="form-control" type="text"/>
			          		</div>
			          	</div>
			          	<div class="col-md-4">
			          		<label for="witnessOne.phone" class="col-md-12">
			          		Phone:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="witnessOne.phone" id="witnessOne.phone" class="form-control phone" type="text"/>
	              			<span style="color: red;"><html:errors path="witnessOne.phone" cssClass="err" /></span>                
			          		</div>
			          	</div>
		          	</div>
	          </div>
	          <div class="col-md-12 margin-left-md">
		          	<div class="form-group">
		          		<div class="col-md-6 sigPad margin-right-xl margin-left-md" id="witOneCanvas">
							<label for="witnessOneSignature" class="col-md-12">
							Witness Signature:   &nbsp;&nbsp;<span id="witOneClear" class="sigClear">Clear</span>
							</label>
							<div class="sig sigWrapper">
							<canvas class="pad" width="458" height="85" id="witnessOneSignature"></canvas>
							<html:hidden path="witnessOne.signature" class="output" id="witOneSignature"/>
							<span style="color: red;"><html:errors path="witnessOne.signature" cssClass="err" /></span>
							</div>
		          		</div>
		          	</div>
	          </div>
		  </div>
		  <br/><br/>
          <div class="row margin-left-sm margin-right-sm">
			  <div class="col-md-12">
		          	<div class="form-group">
			          	<div class="col-md-8">
			          		<label for="witnessTwo.name" class="col-md-12">
			          		Witness Name:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="witnessTwo.name" id="witnessTwo.name" class="form-control" type="text"/>
			          		</div>
			          	</div>
			          	<div class="col-md-4">
			          		<label for="witnessTwo.phone" class="col-md-12">
			          		Phone:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="witnessTwo.phone" id="witnessTwo.phone" class="form-control phone" type="text"/>
	              		    <span style="color: red;"><html:errors path="witnessTwo.phone" cssClass="err" /></span>                
			          		</div>
			          	</div>
		          	</div>
	          </div>
	          <div class="col-md-12 margin-left-md">
		          	<div class="form-group">
		          		<div class="col-md-6 sigPad margin-right-xl margin-left-md" id="witTwoCanvas">
			          		<label for="witnessTwo.signature" class="col-md-12">
							Witness Signature:   &nbsp;&nbsp;<span id="witTwoClear" class="sigClear">Clear</span>
			          		</label>
							<div class="sig sigWrapper">
							<canvas class="pad" width="458" height="85" id="witnessTwoSignature"></canvas>
							<html:hidden path="witnessTwo.signature" class="output" id="witTwoSignature"/>
							<span style="color: red;"><html:errors path="witnessTwo.signature" cssClass="err" /></span>
							</div>
		          		</div>
		          	</div>
	          </div>
		  </div>
        </fieldset>
    </div>
