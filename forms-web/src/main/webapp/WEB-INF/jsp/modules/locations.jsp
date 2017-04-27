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
					<c:if test="${(location.id <= 8 || location.id >= 13) && (location.id < 19 || location.id > 23) && (location.id < 25 || location.id > 31) && (location.id < 39 || location.id > 46) && (location.id < 33 || location.id > 35) && (location.id < 51)}">
                        <label class="checkbox-inline" for="location-${location.id}">
                        <html:checkbox path="locations" id="location-${location.id}" value="${location.id}"/>
                        ${location.subLocation}
                        </label>
                    </c:if>
</c:forEach>
					<c:if test="${locations.key == 'Student Recreation Complex'}">
						<span class="additional-info-wrap">
						<label class="checkbox-inline" for="brewer-courts">
						<input type="checkbox" id="brewer-courts">
						Brewer Courts
						</label>
						<div class="additional-info hide">
							<label class="checkbox-inline" for="location-9">
								<html:checkbox path="locations" id="location-9" value="9"/>
								Brewer Court #7
							</label>
							<label class="checkbox-inline" for="location-10">
								<html:checkbox path="locations" id="location-10" value="10"/>
								Brewer Court #8
							</label>
							<label class="checkbox-inline" for="location-11">
								<html:checkbox path="locations" id="location-11" value="11"/>
								Brewer Court #9
							</label>
							<label class="checkbox-inline" for="location-12">
								<html:checkbox path="locations" id="location-12" value="12"/>
								Brewer Court #10
							</label>
						</div>
						</span>
						<span class="additional-info-wrap">
						<label class="checkbox-inline" for="tigerx">
						<input type="checkbox" id="tigerx">
						TigerX Studios
						</label>
						<div class="additional-info hide">
							<label class="checkbox-inline" for="location-33">
								<html:checkbox path="locations" id="location-33" value="33" />
								TigerX Studio: A
							</label>
							<label class="checkbox-inline" for="location-34">
								<html:checkbox path="locations" id="location-34" value="34" />
								TigerX Studio: B
							</label>
							<label class="checkbox-inline" for="location-35">
								<html:checkbox path="locations" id="location-35" value="35" />
								TigerX Studio: C
							</label>
						</div>
						</span>
						<span class="additional-info-wrap">
						<label class="checkbox-inline" for="racquet">
						<input type="checkbox" id="racquet">
						Racquet Ball Courts
						</label>
						<div class="additional-info hide">
							<label class="checkbox-inline" for="location-19">
								<html:checkbox path="locations" id="location-19" value="19" />
								Racquet Sports Court #1
							</label>
							<label class="checkbox-inline" for="location-20">
								<html:checkbox path="locations" id="location-20" value="20" />
								Racquet Sports Court #2
							</label>
							<label class="checkbox-inline" for="location-21">
								<html:checkbox path="locations" id="location-21" value="21" />
								Racquet Sports Court #3
							</label>
							<label class="checkbox-inline" for="location-22">
								<html:checkbox path="locations" id="location-22" value="22" />
								Racquet Sports Court #4
							</label>
							<label class="checkbox-inline" for="location-23">
								<html:checkbox path="locations" id="location-23" value="23" />
								Racquet Sports Court - Squash
							</label>
						</div>
						</span>
						<span class="additional-info-wrap">
						<label class="checkbox-inline" for="nSrc-courts">
						<input type="checkbox" id="nSrc-courts">
						North SRC
						</label>
						<div class="additional-info hide">
							<label class="checkbox-inline" for="location-26">
								<html:checkbox path="locations" id="location-26" value="26" />
								North SRC Court #1
							</label>
							<label class="checkbox-inline" for="location-27">
								<html:checkbox path="locations" id="location-27" value="27" />
								North SRC Court #2
							</label>
							<label class="checkbox-inline" for="location-28">
								<html:checkbox path="locations" id="location-28" value="28" />
								North SRC Court #3
							</label>
						</div>
						</span>
						<span class="additional-info-wrap">
						<label class="checkbox-inline" for="sSrc-courts">
						<input type="checkbox" id="sSrc-courts">
						South SRC
						</label>
						<div class="additional-info hide">
							<label class="checkbox-inline" for="location-29">
								<html:checkbox path="locations" id="location-29" value="29" />
								South SRC Court #4
							</label>
							<label class="checkbox-inline" for="location-30">
								<html:checkbox path="locations" id="location-30" value="30" />
								South SRC Court #5
							</label>
							<label class="checkbox-inline" for="location-31">
								<html:checkbox path="locations" id="location-31" value="31" />
								South SRC Court #6
							</label>
						</div>
						</span>						
					</c:if>
					<c:if test="${locations.key == 'Outdoor Facilities'}">
						<span class="additional-info-wrap">
						<label class="checkbox-inline" for="hinkson">
						<input type="checkbox" id="hinkson">
						Hinkson Creek
						</label>
						<div class="additional-info hide">
							<label class="checkbox-inline" for="location-40">
								<html:checkbox path="locations" id="location-40" value="40" />
								Hinkson Creek #1
							</label>
							<label class="checkbox-inline" for="location-41">
								<html:checkbox path="locations" id="location-41" value="41" />
								Hinkson Creek #2
							</label>
							<label class="checkbox-inline" for="location-42">
								<html:checkbox path="locations" id="location-42" value="42" />
								Hinkson Creek #3
							</label>
							<label class="checkbox-inline" for="location-43">
								<html:checkbox path="locations" id="location-43" value="43" />
								Hinkson Creek #4
							</label>
						</div>
						</span>
						<span class="additional-info-wrap">
						<label class="checkbox-inline" for="stankowski">
						<input type="checkbox" id="stankowski">
						Stankowski
						</label>
						<div class="additional-info hide">
							<label class="checkbox-inline" for="location-44">
								<html:checkbox path="locations" id="location-44" value="44" />
								Stankowski #1
							</label>
							<label class="checkbox-inline" for="location-45">
								<html:checkbox path="locations" id="location-45" value="45" />
								Stankowski #2
							</label>
							<label class="checkbox-inline" for="location-46">
								<html:checkbox path="locations" id="location-46" value="46" />
								Stankowski #3
							</label>
						</div>
						</span>
						<span class="additional-info-wrap">
						<label class="checkbox-inline" for="epple">
						<input type="checkbox" id="epple">
						Epple
						</label>
						<div class="additional-info hide">
							<label class="checkbox-inline" for="location-51">
								<html:checkbox path="locations" id="location-51" value="51" />
								Epple #1
							</label>
							<label class="checkbox-inline" for="location-52">
								<html:checkbox path="locations" id="location-52" value="52" />
								Epple #2
							</label>
							<label class="checkbox-inline" for="location-53">
								<html:checkbox path="locations" id="location-53" value="53" />
								Epple #3
							</label>
							<label class="checkbox-inline" for="location-54">
								<html:checkbox path="locations" id="location-54" value="54" />
								Epple #4
							</label>
						</div>
						</span>
					</c:if>
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
                             <html:checkbox path="specificLocation.other" id="add-other"/>
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
