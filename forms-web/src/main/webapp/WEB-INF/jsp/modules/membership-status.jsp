<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <div class="form-container padding-bottom-none">
                <fieldset><legend>Membership Status</legend>
	              <span style="color: red;"><html:errors path="membershipStatus.membership" cssClass="err" /></span>                
						<div class="form-group">
							<div class="col-md-12 columns">
								<label class="checkbox-inline" for="student">
							    	<html:checkbox path="membershipStatus.membership" id="student" value="student"/>
							        Student
							        </label>
						         <label class="checkbox-inline" for="nonStudentMember">
						            <html:checkbox path="membershipStatus.membership" id="nonStudentMember" value="nonStudentMember " />
						            Non-Student Member
						         </label>					               
							</div>
							<div class="col-md-9 columns">
							        <span class="additional-info-wrap">
						  	                <span style="color: red;"><html:errors path="membershipStatus.guestExplain" cssClass="err" /></span>                
								        <label class="checkbox-inline" for="guest">
									        <html:checkbox path="membershipStatus.membership" id="guest" value="guest"/>
									        Guest
								        </label>
								        <div class="additional-info hide">
									        <html:input type="text" id="guestExplain" path="membershipStatus.guestExplain" placeholder="Explain Guest Details" class="form-control" disabled=""/>
								        </div>
							        </span>
							</div>
						</div>
                </fieldset>
            </div>
