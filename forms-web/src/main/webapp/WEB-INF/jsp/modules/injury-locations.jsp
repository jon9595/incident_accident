<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

    <div class="form-container padding-bottom-none">
        <fieldset><legend>Injury Location</legend>
	      <span style="color: red;"><html:errors path="injurylocations" cssClass="err" /></span>                
          <div class="row margin-left-sm padding-left-lg padding-right-lg">
          <c:forEach items="${injuryLocationsMap}" var="injMap">
          <c:choose>
          	<c:when test="${fn:length(injMap.value)==1}">
          	<c:set var="inj" value="${injMap.value[0]}"/>
                    <div class="col-md-3 col-sm-6">
                      <div class="form-group">
                        <span class="additional-checked-info-wrap margin-bottom-sm">
                          <label class="checkbox-inline" for="il-${inj.id}">
                           <html:checkbox path="injurylocations" id="il-${inj.id}" value="${inj.id}"/>
                           ${inj.location}
                          </label>
                       </span>
                     </div>
			       </div>
          	</c:when>
          	<c:otherwise>
                    <div class="col-md-3 col-sm-6">
                      <div class="form-group">
                        <span class="additional-checked-info-wrap margin-bottom-sm">
                          <label class="checkbox-inline" for="il-${injMap.key}">
                           <html:checkbox path="injurylocationHdr" id="il-${injMap.key}" class="injury-chkbox" value="il-${injMap.key}"/>
                           ${injMap.key}<span class="spn-injury-chkbox hidden"><br/>Please select one below:</span>
                          </label>
                         <div class="additional-checked-info padding-top-lg padding-bottom-lg hide">
                           <div class="columns-2"> 
          <c:forEach items="${injMap.value}" var="injLocation">
                           <label class="checkbox-inline yes-no" for="il-${injLocation.id}">
                             <html:checkbox class="yes-no" path="injurylocations" id="il-${injLocation.id}" value="${injLocation.id}"/>
                             ${injLocation.subLocation}
                             </label> 
          </c:forEach>
                         </div>
                         </div>
                       </span> 
                      </div>
                    </div>
          	</c:otherwise>
          </c:choose>
          </c:forEach>
          </div>
          <div class="row margin-left-sm padding-left-lg padding-right-lg">
		  <div class="col-md-12">
          	<div class="form-group">
          		<html:hidden path="specInjLocation.id"/>
				<label for="spec-inj-location">
				Specific Injury Location
				</label>
				<html:textarea path="specInjLocation.description" class="form-control margin-bottom-md" id="spec-inj-location" rows="5"/>
          	</div>
          </div>
          </div>
        </fieldset>
    </div>
