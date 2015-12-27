<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div class="form-container padding-bottom-none">
          <div class="row margin-left-sm margin-right-sm">
			  <div class="col-md-12">
		          	<div class="form-group">
			          	<div class="col-md-5">
			          		<label for="properNotifications.reportCompletedBy" class="col-md-12">
			          		Report Completed By:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="properNotifications.reportCompletedBy" id="properNotifications.reportCompletedBy" class="form-control" type="text"/>
							<span style="color: red;"><html:errors path="properNotifications.reportCompletedBy" cssClass="err" /></span>
			          		</div>
			          	</div>
			          	<div class="col-md-5">
			          		<label for="properNotifications.rptCmpltPosition" class="col-md-12">
			          		Position:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="properNotifications.rptCmpltPosition" id="properNotifications.rptCmpltPosition" class="form-control" type="text"/>
							<span style="color: red;"><html:errors path="properNotifications.rptCmpltPosition" cssClass="err" /></span>
			          		</div>
			          	</div>
			          	<div class="col-md-2">
			          		<label for="properNotifications.rptCmpltDateStr" class="col-md-12">
			          		Date:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="properNotifications.rptCmpltDateStr" id="rptCmpltDateStr" class="form-control date" type="text"/>
							<span style="color: red;"><html:errors path="properNotifications.rptCmpltDateStr" cssClass="err" /></span>
			          		</div>
			          	</div>
		          	</div>
	          </div>

			  <div class="col-md-12">
		          	<div class="form-group">
			          	<div class="col-md-5">
			          		<label for="properNotifications.rptReviewedBy" class="col-md-12">
			          		Reviewed By:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="properNotifications.rptReviewedBy" id="properNotifications.rptReviewedBy" class="form-control" type="text"/>
			          		</div>
			          	</div>
			          	<div class="col-md-5">
			          		<label for="properNotifications.rptReviewerPosition" class="col-md-12">
			          		Position:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="properNotifications.rptReviewerPosition" id="properNotifications.rptReviewerPosition" class="form-control" type="text"/>
			          		</div>
			          	</div>
			          	<div class="col-md-2">
			          		<label for="properNotifications.rptReviewerDateStr" class="col-md-12">
			          		Date:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="properNotifications.rptReviewerDateStr" id="rptReviewerDateStr" class="form-control date" type="text"/>
			          		</div>
			          	</div>
		          	</div>
	          </div>
          </div>
    </div>
