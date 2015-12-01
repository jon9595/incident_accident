<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <div class="form-container padding-bottom-none">
                <fieldset><legend>Program or Activity Involved</legend>
                  <div class="form-group">
                    <div class="col-md-12 columns-3"> 
                      <span class="additional-info-wrap margin-bottom-sm">
                        <label class="checkbox-inline" for="informalActivity">
                         <html:checkbox path="programActivity.programActivity" id="informalActivity" value="informalActivity"/>
                         Informal Activity (General Recreation, Pickup sports, Lap Swim, etc.)
                        </label>
                       <div class="additional-info hide">
                        <html:input type="text" id="infActDesc" path="programActivity.infActDesc" placeholder="Explain" class="form-control" disabled=""/>
                       </div>
                     </span> 

                      <span class="additional-info-wrap margin-bottom-sm">
                        <label class="checkbox-inline" for="swimTeamPractice">
                         <html:checkbox path="programActivity.programActivity" id="swimTeamPractice" value="swimTeamPractice"/>
                         Swim Team Practice
                        </label>
                       <div class="additional-info hide">
                        <html:input type="text" id="swimTeamName" path="programActivity.swimTeamName" placeholder="Swim Team Name" class="form-control" disabled=""/>
                       </div>
                     </span> 

                      <span class="additional-info-wrap margin-bottom-sm">
                        <label class="checkbox-inline" for="specEvt">
                         <html:checkbox path="programActivity.programActivity" id="specEvt" value="specEvt"/>
                         Special Event
                        </label>
                       <div class="additional-info hide">
                        <html:input type="text" id="specEvtGroup" path="programActivity.specEvtGroup" placeholder="Group Name" class="form-control" disabled=""/>
                       </div>
                     </span> 

                      <span class="additional-info-wrap margin-bottom-sm">
                        <label class="checkbox-inline" for="clubRecSports">
                         <html:checkbox path="programActivity.programActivity" id="clubRecSports" value="clubRecSports"/>
                         Club
                        </label>
                       <div class="additional-info hide">
                        <html:input type="text" id="clubRecTeamName" path="programActivity.clubRecTeamName" placeholder="Club Team Name" class="form-control" disabled=""/>
                       </div>
                     </span> 

                     <span class="additional-info-wrap margin-bottom-sm">
                       <label class="checkbox-inline" for="tigerxPt">
                         <html:checkbox path="programActivity.programActivity" id="tigerxPt" value="tigerxPt"/>
                         Tiger X
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
                       Intercollegiate Athletics
                      </label>

                      <span class="additional-info-wrap margin-bottom-sm">
                        <label class="checkbox-inline" for="recSports">
                         <html:checkbox path="programActivity.programActivity" id="recSports" value="recSports"/>
                         Rec Sports
                        </label>
                       <div class="additional-info hide">
                        <html:input type="text" id="recTeamName" path="programActivity.recTeamName" placeholder="Rec Team Name" class="form-control" disabled=""/>
                       </div>
                     </span> 

                   </div>
                  </div>
                </fieldset> 
            </div>
