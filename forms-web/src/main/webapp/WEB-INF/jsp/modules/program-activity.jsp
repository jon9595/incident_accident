<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <div class="form-container padding-bottom-none">
                <fieldset><legend>Program or Activity Involved</legend>
                  <div class="form-group">
                    <div class="col-md-12 columns-3"> 
                      <span class="additional-info-wrap margin-bottom-sm">
                        <label class="checkbox-inline" for="pa-informal">
                         <input type="checkbox" name="program-activity" id="pa-informal" value="pa-informal">
                         Informal Activity (General Recreation, Pickup sports, Lap Swim, etc.)
                        </label>
                       <div class="additional-info hide">
                        <input type="text" id="pa-informal-xplain" name="pa-informal-xplain" placeholder="Explain" class="form-control" disabled="">
                       </div>
                     </span> 

                      <span class="additional-info-wrap margin-bottom-sm">
                        <label class="checkbox-inline" for="pa-swim">
                         <input type="checkbox" name="program-activity" id="pa-swim" value="pa-swim">
                         Swim Team Practice
                        </label>
                       <div class="additional-info hide">
                        <input type="text" id="pa-swim-team" name="pa-swim-team" placeholder="Swim Team Name" class="form-control" disabled="">
                       </div>
                     </span> 

                      <span class="additional-info-wrap margin-bottom-sm">
                        <label class="checkbox-inline" for="pa-spec-evt">
                         <input type="checkbox" name="program-activity" id="pa-spec-evt" value="pa-spec-evt">
                         Special Event
                        </label>
                       <div class="additional-info hide">
                        <input type="text" id="pa-spec-evt-gp-name" name="pa-spec-evt-gp-name" placeholder="Group Name" class="form-control" disabled="">
                       </div>
                     </span> 

                      <span class="additional-info-wrap margin-bottom-sm">
                        <label class="checkbox-inline" for="pa-club">
                         <input type="checkbox" name="program-activity" id="pa-club" value="pa-club">
                         Club
                        </label>
                       <div class="additional-info hide">
                        <input type="text" id="pa-club-team" name="pa-club-team" placeholder="Club Team Name" class="form-control" disabled="">
                       </div>
                     </span> 

                     <span class="additional-info-wrap margin-bottom-sm">
                       <label class="checkbox-inline" for="pa-tigerx">
                         <input type="checkbox" name="program-activity" id="pa-tigerx" value="pa-tigerx">
                         Tiger X
                       </label> 
                       <div class="additional-info hide">
                         <input type="text" id="pa-tigerx-program" name="pa-tigerx-program" placeholder="Program Name" class="form-control" disabled="">
                       </div>
                       <div class="additional-info hide">
                         <input type="text" id="pa-tigerx-instructor" name="pa-tigerx-instructor" placeholder="Instructor Name" class="form-control margin-top-sm" disabled="">
                       </div>
                     </span>

                      <label class="checkbox-inline" for="pa-inter-coll">
                       <input type="checkbox" name="program-activity" id="pa-inter-coll" value="pa-inter-coll">
                       Intercollegiate Athletics
                      </label>

                      <span class="additional-info-wrap margin-bottom-sm">
                        <label class="checkbox-inline" for="pa-rec">
                         <input type="checkbox" name="program-activity" id="pa-rec" value="pa-rec">
                         Rec Sports
                        </label>
                       <div class="additional-info hide">
                        <input type="text" id="pa-rec-team" name="pa-rec-team" placeholder="Rec Team Name" class="form-control" disabled="">
                       </div>
                     </span> 

                   </div>
                  </div>
                </fieldset> 
            </div>
