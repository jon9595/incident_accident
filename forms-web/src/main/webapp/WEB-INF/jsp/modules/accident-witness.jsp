<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		          		<label for="witnessOne.signature" class="col-md-12">
		          		Signature:
		          		</label>
		          		<div class="col-md-12">
		          		<html:textarea path="witnessOne.signature" id="witnessOne.signature" class="form-control" rows="5"/>
	              		<span style="color: red;"><html:errors path="witnessOne.signature" cssClass="err" /></span>                
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
		          		<label for="witnessTwo.signature" class="col-md-12">
		          		Signature:
		          		</label>
		          		<div class="col-md-12">
		          		<html:textarea path="witnessTwo.signature" id="witnessTwo.signature" class="form-control" rows="5"/>
	              		<span style="color: red;"><html:errors path="witnessTwo.signature" cssClass="err" /></span>                
		          		</div>
		          	</div>
	          </div>
		  </div>
        </fieldset>
    </div>
