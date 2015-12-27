package edu.mizzou.incidentaccident.web.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mizzou.incidentaccident.api.models.AccidentModel;
import edu.mizzou.incidentaccident.api.models.IncidentModel;
import edu.mizzou.incidentaccident.web.common.util.ValidationUtils;

@Component
public class IncidentValidator implements Validator {

	DemographicsValidator dv = new DemographicsValidator();
	MembershipStatusValidator msv = new MembershipStatusValidator();
	ProgramActivityValidator pav = new ProgramActivityValidator();
	ProperNotificationsValidator pnv = new ProperNotificationsValidator();
	WitnessInfoValidator wiv = new WitnessInfoValidator();
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(IncidentModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		IncidentModel incident = (IncidentModel)target;
		dv.validate(incident.getDemographics(), errors);
		msv.validate(incident.getMembershipStatus(), errors);
		pav.validate(incident.getProgramActivity(), errors);
		pnv.validate(incident.getProperNotifications(), errors);
		if (incident.getLocations().length == 0) {
			errors.rejectValue("locations", "required", null, "Location is required.");
		}
		if (incident.getSpecificLocation().isSpecEquipPiece()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "specificLocation.specEquipPieceDesc", "required", "Please specify equipment piece.");
		}
		if (incident.getSpecificLocation().isOther()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "specificLocation.otherDesc", "required", "Please specify other.");
		}
		incident.getWitnessInfo().setClassName("witnessInfo");
		wiv.validate(incident.getWitnessInfo(), errors);
		
	}

}
