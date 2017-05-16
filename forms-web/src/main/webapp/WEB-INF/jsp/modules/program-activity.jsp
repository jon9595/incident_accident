<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <div class="form-container padding-bottom-none">
                <fieldset><legend>Program or Activity Involved</legend>
	              <span style="color: red;"><html:errors path="programActivity.programActivity" cssClass="err" /></span>
                  <div class="form-group">
                    <div class="col-md-12 columns-3"> 
                      <span class="additional-info-wrap margin-bottom-sm">
						<span style="color: red;"><html:errors path="programActivity.infActDesc" cssClass="err" /></span>
                        <label class="checkbox-inline" for="informalActivity">
                         <html:checkbox path="programActivity.programActivity" id="informalActivity" value="informalActivity"/>
                         Informal Activity (General Recreation, Pickup sports, Lap Swim, etc.)
                        </label>
                       <div class="additional-info hide">
                        <html:input type="text" id="infActDesc" path="programActivity.infActDesc" placeholder="Explain" class="form-control" disabled=""/>
                       </div>
                     </span> 

                      <span class="additional-info-wrap margin-bottom-sm">
						<span style="color: red;"><html:errors path="programActivity.swimTeamName" cssClass="err" /></span>
                        <label class="checkbox-inline" for="swimTeamPractice">
                         <html:checkbox path="programActivity.programActivity" id="swimTeamPractice" value="swimTeamPractice"/>
                         Swim Team Practice
                        </label>
                       <div class="additional-info hide">
                        <html:input type="text" id="swimTeamName" path="programActivity.swimTeamName" placeholder="Swim Team Name" class="form-control" disabled=""/>
                       </div>
                     </span> 

                      <span class="additional-info-wrap margin-bottom-sm">
						<span style="color: red;"><html:errors path="programActivity.specEvtGroup" cssClass="err" /></span>
                        <label class="checkbox-inline" for="specEvt">
                         <html:checkbox path="programActivity.programActivity" id="specEvt" value="specEvt"/>
                         Special Event
                        </label>
                       <div class="additional-info hide">
                        <html:input type="text" id="specEvtGroup" path="programActivity.specEvtGroup" placeholder="Event Name" class="form-control" disabled=""/>
                       </div>
                     </span> 

                      <span class="additional-info-wrap margin-bottom-sm">
						<span style="color: red;"><html:errors path="programActivity.clubRecTeamName" cssClass="err" /></span>
                        <label class="checkbox-inline" for="clubRecSports">
                         <html:checkbox path="programActivity.programActivity" id="clubRecSports" value="clubRecSports"/>
                         Club Sports
                        </label>
                       <div class="additional-info hide">
                        <html:input type="text" id="clubRecTeamName" path="programActivity.clubRecTeamName" placeholder="Club Team Name" class="form-control" disabled=""/>
                       </div>
                     </span> 

                     <span class="additional-info-wrap margin-bottom-sm">
						<span style="color: red;"><html:errors path="programActivity.tigerxPrgName" cssClass="err" /></span>
						<span style="color: red;"><html:errors path="programActivity.tigerxPtInstructor" cssClass="err" /></span>
                       <label class="checkbox-inline" for="tigerxPt">
                         <html:checkbox path="programActivity.programActivity" id="tigerxPt" value="tigerxPt"/>
                         Tiger X/Personal Training/LHP
                       </label> 
                       <div class="additional-info hide">
                         <html:input type="text" id="tigerxPrgName" path="programActivity.tigerxPrgName" placeholder="Program Name" class="form-control" disabled=""/>
                       </div>
                       <div class="additional-info hide">
                         <html:input type="text" id="tigerxPtInstructor" path="programActivity.tigerxPtInstructor" placeholder="Instructor Name" class="form-control margin-top-sm" disabled=""/>
                       </div>
                     </span>

                      <label class="checkbox-inline" for="interAthletics">
                       <html:checkbox path="programActivity.programActivity" id="interAthletics" value="interAthletics"/>
                       Mizzou Swim & Dive
                      </label>

                      <span class="additional-info-wrap margin-bottom-sm">
						<span style="color: red;"><html:errors path="programActivity.recTeamName" cssClass="err" /></span>
                        <label class="checkbox-inline" for="recSports">
                         <html:checkbox path="programActivity.programActivity" id="recSports" value="recSports"/>
                         RecSports
                        </label>
                       <div class="additional-info hide">
                        <html:input type="text" id="recTeamName" path="programActivity.recTeamName" placeholder="RecSports Team Name" class="form-control" disabled=""/>
                       </div>
                     </span> 

                   </div>
                  </div>
                </fieldset> 
            </div>
