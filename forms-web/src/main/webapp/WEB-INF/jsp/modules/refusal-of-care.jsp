<%@ taglib uri="http://www.springframework.org/tags/form" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div class="form-container padding-bottom-none">
        <fieldset><legend>Refusal of Care <small class="text-muted">(If guest refuses medical care)</small></legend>
        <p class="text-muted">The staff of MizzouRec has informed the injured party that they have a suspected medical injury.  At this time, 
        the injured party has refused the care of MizzouRec personnel and decided to seek care on their own.  By signing, the injured party
        agrees to hold the University of Missouri and the staff of MizzouRec harmless from any further actions as a result of their suspected
        injury.  <u>The injured party understands that he or she must exit the facility and discontinue use of any MizzouRec facilities for 
        the remainder of the day.</u></p>
          <div class="row margin-left-sm margin-right-sm">
		  <div class="col-md-12">
          	<div class="form-group">
          		<div class="col-md-9">
				<label for="refusalCare">
				Member Signature
				</label>
				<html:textarea path="refusalOfCare.memberSignature" class="form-control col-md-6 margin-bottom-md" id="refusalCare" rows="5"/>
          		</div>
          		<div class="col-md-3">
				<label for="memberRefusalDate">
				Date
				</label>
				<html:input type="text" path="refusalOfCare.dateStr" class="form-control col-md-3 margin-bottom-md date" id="memberRefusalDate"/>
          		</div>
          	</div>
          </div>
          </div>
        </fieldset>
	</div>
