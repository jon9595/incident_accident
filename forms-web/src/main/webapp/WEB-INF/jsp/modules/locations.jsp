<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <div class="form-container padding-bottom-none">
                <fieldset><legend>Location</legend>
	              <span style="color: red;"><html:errors path="locations" cssClass="err" /></span>                
                  <div class="margin-left-lg">
<c:forEach items="${locationsMap}" var="locations">
                    <fieldset><legend>${locations.key}</legend>
	                    <div class="form-group">
	                      <div class="col-md-12 columns"> 
<c:forEach items="${locations.value}" var="location">
                        <label class="checkbox-inline" for="location-${location.id}">
                        <html:checkbox path="locations" id="location-${location.id}" value="${location.id}"/>
                        ${location.subLocation}
                        </label>
</c:forEach>
	                      </div>
	                    </div>
					</fieldset>
</c:forEach>
                <fieldset><legend>Additional</legend>
                    <div class="form-group">
                      <div class="col-md-9 columns"> 
						<span style="color: red;"><html:errors path="specificLocation.specEquipPieceDesc" cssClass="err" /></span>                
                        <span class="additional-info-wrap">
                           <label class="checkbox-inline" for="specificLocationSet">
                             <html:checkbox path="specificLocation.specEquipPiece" id="specificLocationSet" />
                             Specific Equipment Piece
                           </label> 
                           <div class="additional-info hide">
                             <html:input type="text" id="location-add-spec-equip" path="specificLocation.specEquipPieceDesc" placeholder="Specific Equipment Piece" class="form-control" disabled=""/>
                           </div>
                         </span>

						<span style="color: red;"><html:errors path="specificLocation.otherDesc" cssClass="err" /></span>                
                        <span class="additional-info-wrap">
                           <label class="checkbox-inline" for="add-other">
                             <html:checkbox path="specificLocation.other" id="add-other" class="checkbox"/>
                             Other
                           </label> 
                           <div class="additional-info hide">
                             <html:input type="text" id="location-add-other-explain" path="specificLocation.otherDesc" placeholder="Please Explain" class="form-control" disabled=""/>
                           </div>
                         </span>

                      </div>
                    </div>
                </fieldset>

                  </div>
                </fieldset>


            </div>
