<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div class="form-container padding-bottom-none">
        <fieldset><legend>Proper Notifications</legend>
          <div class="margin-left-lg">
          	<fieldset><legend>MUPD (Radio Ch. 6, 882-7201)</legend>
          	<div class="row margin-left-sm">
          		<div class="col-md-12">
		          	<div class="form-group">
		          	<span class="additional-info-wrap">
		          	<label class="control-label margin-right-lg">Was MUPD Contacted?</label> 
						 <span style="color: red;"><html:errors path="properNotifications.mupdContacted" cssClass="err" /></span>
	                     <label class="radio-inline" for="mupd-y">
	                     <html:radiobutton id="mupd-y" value="Y" path="properNotifications.mupdContacted"/>
	                     Yes
	                     </label> 
	                    <div class="additional-info hide"> 
		          		<label for="properNotifications.mupdOfficerName" class="col-md-12">
		          		Officer Responding:
		          		</label>
		          		<div class="col-md-12">
		          		<html:input path="properNotifications.mupdOfficerName" id="properNotifications.mupdOfficerName" class="form-control" type="text"/>
						<span style="color: red;"><html:errors path="properNotifications.mupdOfficerName" cssClass="err" /></span>
		          		</div>
		          		<div class="row">
			          		<div class="col-md-4">
			          			<label for="pNmupdCalled" class="col-md-12">
			          			Time Called:
			          			</label>
				          		<div class="col-md-12">
				          		<html:input path="properNotifications.mupdOfficerCalledStr" id="pNmupdCalled" class="form-control time" type="text" size="5"/>
								<span style="color: red;"><html:errors path="properNotifications.mupdOfficerCalledStr" cssClass="err" /></span>
				          		</div>
			          		</div>
			          		<div class="col-md-4">
			          			<label for="pNmupdArrived" class="col-md-12">
			          			Time Arrived:
			          			</label>
				          		<div class="col-md-12">
				          		<html:input path="properNotifications.mupdOfficerArrivedStr" id="pNmupdArrived" class="form-control time" type="text" size="5"/>
				          		<span style="color: red;"><html:errors path="properNotifications.mupdOfficerArrivedStr" cssClass="err" /></span>
				          		</div>
			          		</div>
			          		<div class="col-md-4">
			          			<label for="properNotifications.mupdOfficerCaseNbr" class="col-md-12">
			          			Case #:
			          			</label>
				          		<div class="col-md-12">
				          		<html:input path="properNotifications.mupdOfficerCaseNbr" id="properNotifications.mupdOfficerCaseNbr" class="form-control" type="text"/>
				          		<span style="color: red;"><html:errors path="properNotifications.mupdOfficerCaseNbr" cssClass="err" /></span>
				          		</div>
			          		</div>
		          		</div>
		          		</div>
		          		</span>
		          		<label class="radio-inline" for="mupd-n">
	                     <html:radiobutton id="mupd-n" value="N" path="properNotifications.mupdContacted"/>
	                     No
	                     </label>
		          	</div>
          		</div>
          	</div>
          	</fieldset>
          	<br/>
          	<fieldset>
          		<legend>EMS&nbsp;&nbsp;<small class="text-muted">(Professional Staff must be contacted if EMS is contacted)</small></legend>
          		<div class="row margin-left-sm">
          		<div class="form-group">
          			<div class="col-md-12">
		                 <label class="control-label margin-right-lg">Was EMS Contacted?</label> 
						 <span style="color: red;"><html:errors path="properNotifications.emsContacted" cssClass="err" /></span>
						 <span class="additional-info-wrap">
	                     <label class="radio-inline" for="ems-y">
	                     <html:radiobutton id="ems-y" value="Y" path="properNotifications.emsContacted"/>
	                     Yes
	                     </label>
	                     <div class="additional-info hide"> 
	                     <div class="row">
	          				<label for="pNentUsed" class="col-md-12">
	          				Entrance Used:
	          				</label>
	          			</div>
	          			<div class="row">
		          		<div class="col-md-12">
		          		<html:input path="properNotifications.emsEntrance" id="pNentUsed" class="form-control margin-bottom-md" type="text"/>
						 <span style="color: red;"><html:errors path="properNotifications.emsEntrance" cssClass="err" /></span>
		          		</div>
		          		<div class="col-md-6 padding-left-none">
		          			<label for="pNtimeCalled" class="col-md-12">
		          			Time Called:
		          			</label>
			          		<div class="col-md-12">
			          		<html:input path="properNotifications.emsCalledStr" id="pNtimeCalled" class="form-control margin-bottom-sm time" type="text"/>
							 <span style="color: red;"><html:errors path="properNotifications.emsCalledStr" cssClass="err" /></span>
			          		</div>
		          		</div>
		          		<div class="col-md-6">
		          			<label for="pNtimeArrived" class="col-md-12">
		          			Time Arrived:
		          			</label>
			          		<div class="col-md-12">
			          		<html:input path="properNotifications.emsArrivedStr" id="pNtimeArrived" class="form-control margin-bottom-sm time" type="text"/>
							 <span style="color: red;"><html:errors path="properNotifications.emsArrivedStr" cssClass="err" /></span>
			          		</div>
		          		</div>
		          		</div>
		          		</div>
		          		</span>
		          		<label class="radio-inline" for="ems-n">
	                     <html:radiobutton id="ems-n" value="N" path="properNotifications.emsContacted"/>
	                     No
	                     </label>
          			 </div>
          			</div>
          			</div>
          			</fieldset>
          			<fieldset>
          			<legend>Professional Staff&nbsp;&nbsp;<small class="text-muted">(Required if EMS is contacted)</small></legend>
          			<div class="row margin-left-sm">
          			<div class="form-group">
          			<div class="col-md-12">
		                 <label class="control-label margin-right-lg">Professional Staff Contacted?</label> 
						 <span style="color: red;"><html:errors path="properNotifications.profStaffContacted" cssClass="err" /></span>
						 <span class="additional-info-wrap">
						 <label class="radio-inline" for="psc-y">
	                     <html:radiobutton id="psc-y" value="Y" path="properNotifications.profStaffContacted"/>
	                     Yes
	                     </label> 
						<div class="additional-info hide">
						<div class="row">
	          			<label for="profStaffName" class="col-md-12">
	          			Professional Staff Member Called:
	          			</label>
		          		<div class="col-md-12">
		          		<html:input path="properNotifications.profStaffName" id="profStaffName" class="form-control margin-bottom-md" type="text"/>
						 <span style="color: red;"><html:errors path="properNotifications.profStaffName" cssClass="err" /></span>
		          		</div>
		          		</div>
		          		<div class="row">
		          		<div class="col-md-6 padding-left-none">
		          			<label for="profStaffCalled" class="col-md-12">
		          			Time Called:
		          			</label>
			          		<div class="col-md-12">
			          		<html:input path="properNotifications.profStaffCalledStr" id="profStaffCalled" class="form-control margin-bottom-sm time" type="text"/>
							 <span style="color: red;"><html:errors path="properNotifications.profStaffCalledStr" cssClass="err" /></span>
			          		</div>
		          		</div>
		          		<div class="col-md-6">
		          			<label for="profStaffArrived" class="col-md-12">
		          			Time Arrived:
		          			</label>
			          		<div class="col-md-12">
			          		<html:input path="properNotifications.profStaffArrivedStr" id="profStaffArrived" class="form-control margin-bottom-sm time" type="text"/>
							 <span style="color: red;"><html:errors path="properNotifications.profStaffArrivedStr" cssClass="err" /></span>
			          		</div>
		          		</div>
		          		</div>
		          		</div>
		          		</span>
		          		<label class="radio-inline" for="psc-n">
	                     <html:radiobutton id="psc-n" value="N" path="properNotifications.profStaffContacted"/>
	                     No
	                     </label> 
          			</div>
          			</div>
          		</div>
          		</fieldset>
          		<fieldset>
          			<legend>Athletic Trainer&nbsp;&nbsp;</legend>
          			<div class="row margin-left-sm">
          			<div class="form-group">
          			<div class="col-md-12">
		                 <label class="control-label margin-right-lg">Athletic Trainer Contacted?</label> 
						 <span style="color: red;"><html:errors path="properNotifications.athleticTrainerContacted" cssClass="err" /></span>
						 <span class="additional-info-wrap">
						 	<label class="radio-inline" for="atc-y">
	                     	<html:radiobutton id="atc-y" value="Y" path="properNotifications.athleticTrainerContacted"/>
	                     	Yes
	                     	</label> 
							<div class="additional-info hide">
								<div class="row">
									<label class="control-label margin-right-lg">&nbsp;&nbsp;Did the trainer provide care?</label> 
		          					<label for="atc-care-y" class="radio-inline">
		          					<html:radiobutton id="atc-care-y" value="Y" path="properNotifications.athleticTrainerCare" />
		          					Yes
		          					</label>
		          					<label for="atc-care-n" class="radio-inline">
		          					<html:radiobutton id="atc-care-n" value="N" path="properNotifications.athleticTrainerCare" />
		          					No
		          					</label>
			          			</div>
			          		</div>
		          		</span>
		          		<label class="radio-inline" for="atc-n">
	                     <html:radiobutton id="atc-n" value="N" path="properNotifications.athleticTrainerContacted"/>
	                     No
	                     </label> 
          			</div>
          			</div>
          		</div>
          		</fieldset>
          		<fieldset>
          			<legend>Report Filed By</legend>
          				<div class="row margin-left-sm">
          					<div class="form-group">
          						<div class="col-md-12">
          							<label for="reportFiledBy" class="col-md-12">
          							Who filed this report?
          							</label>
									<html:input path="properNotifications.reportFiledBy" id="reportFiledBy" class="form-control margin-bottom-md" type="text" />
									<span style="color: red";"><html:errors path="properNotifications.reportFiledBy" cssClass="err" /></span>          						
          						</div>
          					</div>
          				</div>
          		</fieldset>
          </div>
        </fieldset>
	</div>
