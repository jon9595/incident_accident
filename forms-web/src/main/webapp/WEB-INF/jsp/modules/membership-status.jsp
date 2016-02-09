<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <div class="form-container padding-bottom-none">
	  			  <span style="color: red;">${errMsg}</span>
                <fieldset><legend>Membership Status</legend>
	              <span style="color: red;"><html:errors path="membershipStatus.membership" cssClass="err" /></span>                
						<div class="form-group">
							<div class="col-md-12 columns">
								<label class="checkbox-inline" for="student">
						            <html:checkbox path="membershipStatus.membership" id="student" value="student"/>
						            Student
						            </label> 
					                <label class="checkbox-inline" for="faculty">
						                <html:checkbox path="membershipStatus.membership" id="faculty" value="facultyStaff"/>
						                Faculty/Staff
					                </label> 
					                <label class="checkbox-inline" for="alumni">
						                <html:checkbox path="membershipStatus.membership" id="alumni" value="alumni"/>
						                Alumni
					                </label>
					                <label class="checkbox-inline" for="guest">
						                <html:checkbox path="membershipStatus.membership" id="guest" value="guest"/>
						                Guest
					                </label> 
							        <label class="checkbox-inline" for="tigerXpress">
								        <html:checkbox path="membershipStatus.membership" id="tigerXpress" value="tigerXpress"/>
								        Tiger Express
							        </label> 
							        <label class="checkbox-inline" for="stopOutStudent">
								        <html:checkbox path="membershipStatus.membership" id="stopOutStudent" value="stopOutStudent"/>
								        Stop-Out Student
							        </label> 
							        <label class="checkbox-inline" for="houseHoldAdult">
								        <html:checkbox path="membershipStatus.membership" id="houseHoldAdult" value="houseHoldAdult"/>
								        Household Adult
							        </label> 
							</div>
							<div class="col-md-9 columns">
							        <span class="additional-info-wrap">
						  	                <span style="color: red;"><html:errors path="membershipStatus.otherExplain" cssClass="err" /></span>                
								        <label class="checkbox-inline" for="other">
									        <html:checkbox path="membershipStatus.membership" id="other" value="other"/>
									        Other
								        </label>
								        <div class="additional-info hide">
									        <html:input type="text" id="otherExplain" path="membershipStatus.otherExplain" placeholder="Explain" class="form-control" disabled=""/>
								        </div>
							        </span>
							</div>
						</div>
                </fieldset>
            </div>
