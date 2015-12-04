<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div class="form-container padding-bottom-none">
        <fieldset><legend>Proper Notifications</legend>
          <div class="margin-left-lg">
          	<fieldset><legend>MUPD (Radio Ch. 6, 82-7201)</legend>
          	<div class="row margin-left-sm">
          		<div class="col-md-6">
		          	<div class="form-group">
		          		<label for="properNotifications.mupdOfficerName" class="col-md-12">
		          		Officer Responding:
		          		</label>
		          		<div class="col-md-12">
		          		<html:input path="properNotifications.mupdOfficerName" id="properNotifications.mupdOfficerName" class="form-control" type="text"/>
		          		</div>
		          	</div>
          		</div>
          		<div class="col-md-6">
		          	<div class="form-group">
		          		<div class="row">
			          		<div class="col-md-6">
			          			<label for="pNmupdCalled" class="col-md-12">
			          			Time Called:
			          			</label>
				          		<div class="col-md-12">
				          		<html:input path="properNotifications.mupdOfficerCalled" id="pNmupdCalled" class="form-control time" type="text" size="5"/>
				          		</div>
			          		</div>
			          		<div class="col-md-6">
			          			<label for="pNmupdArrived" class="col-md-12">
			          			Time Arrived:
			          			</label>
				          		<div class="col-md-12">
				          		<html:input path="properNotifications.mupdOfficerArrived" id="pNmupdArrived" class="form-control time" type="text" size="5"/>
				          		</div>
			          		</div>
		          		</div>
		          	</div>
          		</div>
          	</div>
          	</fieldset>
          </div>
        </fieldset>
	</div>
