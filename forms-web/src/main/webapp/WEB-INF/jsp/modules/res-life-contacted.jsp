<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div class="form-container padding-bottom-none">
          <div class="row margin-left-sm margin-right-sm">
 	          <div class="col-md-12">
		          	<div class="form-group">
			          	<div class="col-md-5 padding-top-lg padding-left-xl">
			          	Res. Life Contact: Kristen Temple (<a href="mailto:templek@missouri.edu">templek@missouri.edu</a>)
			          	</div>
			          	<div class="col-md-4">
			                 <label class="col-md-12">Email Sent:</label> 
			                 <div class="col-md-12">
								 <span style="color: red;"><html:errors path="properNotifications.resLifeContEmailSent" cssClass="err" /></span>
			                     <label class="radio-inline" for="rsce-y">
			                     <html:radiobutton id="rsce-y" value="Y" path="properNotifications.resLifeContEmailSent"/>
			                     Yes
			                     </label> 
			                     <label class="radio-inline" for="rsce-n">
			                     <html:radiobutton id="rsce-n" value="N" path="properNotifications.resLifeContEmailSent"/>
			                     No
			                     </label> 
			                 </div>
			          	</div>
			          	<div class="col-md-2 col-md-offset-1">
			          		<label for="properNotifications.resLifeContDateSentStr" class="col-md-12">
			          		Date:
			          		</label>
			          		<div class="col-md-12">
			          		<html:input path="properNotifications.resLifeContDateSentStr" id="resLifeContDateSentStr" class="form-control date" type="text"/>
							<span style="color: red;"><html:errors path="properNotifications.resLifeContDateSentStr" cssClass="err" /></span>
			          		</div>
			          	</div>
		          	</div>
	          </div>
          </div>
    </div>
