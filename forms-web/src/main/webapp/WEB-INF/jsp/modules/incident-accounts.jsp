<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div class="form-container padding-bottom-none">
        <fieldset><legend>Responder Account; Staff Response and Actions:</legend>
          <div class="row margin-left-sm margin-right-sm">
		  <div class="col-md-12">
          	<div class="form-group">
				<label for="responderAcct">
			        <p class="text-muted">(Describe the events of the incident, including all patrons and Team Mizzou staff involved, MUPD or Medical involvement, etc.)</p>
				</label>
				<html:textarea path="responderAcct.acctDesc" class="form-control margin-bottom-md" id="responderAcct" rows="8"/>
          	</div>
          </div>
          </div>
        </fieldset>
	</div>
    <div class="form-container padding-bottom-none">
        <fieldset><legend>Member Account</legend>
          <div class="row margin-left-sm margin-right-sm">
		  <div class="col-md-12">
          	<div class="form-group">
				<label for="memberAccount">
			        <p class="text-muted">(Describe the events of the incident, including all patrons and Team Mizzou staff involved, MUPD or Medical involvement, etc.)</p>
				</label>
				<html:textarea path="memberAcct.acctDesc" class="form-control margin-bottom-md" id="memberAccount" rows="8"/>
          	</div>
          </div>
          </div>
        </fieldset>

    </div>
    <div class="form-container padding-bottom-none">
        <fieldset><legend>Witness Incident Account</legend>
          <div class="row margin-left-sm margin-right-sm">
		  <div class="col-md-12">
          	<div class="form-group">
				<label for="witnessAccount">
			        <p class="text-muted">(Describe the events of the incident.)</p>
				</label>
				<html:textarea path="witnessAcct.acctDesc" class="form-control margin-bottom-md" id="witnessAccount" rows="8"/>
          	</div>
          </div>
          </div>
        </fieldset>

    </div>
    