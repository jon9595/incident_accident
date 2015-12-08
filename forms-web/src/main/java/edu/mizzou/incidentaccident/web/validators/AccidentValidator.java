package edu.mizzou.incidentaccident.web.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mizzou.incidentaccident.api.models.AccidentModel;
import edu.mizzou.incidentaccident.web.common.util.ValidationUtils;

@Component
public class AccidentValidator implements Validator {

	DemographicsValidator dv = new DemographicsValidator();
	MembershipStatusValidator msv = new MembershipStatusValidator();
	ProgramActivityValidator pav = new ProgramActivityValidator();
	ProperNotificationsValidator pnv = new ProperNotificationsValidator();
	WitnessInfoValidator wiv = new WitnessInfoValidator();
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(AccidentModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AccidentModel accident = (AccidentModel)target;
		dv.validate(accident.getDemographics(), errors);
		msv.validate(accident.getMembershipStatus(), errors);
		pav.validate(accident.getProgramActivity(), errors);
		pnv.validate(accident.getProperNotifications(), errors);
		accident.getWitnessOne().setClassName("witnessOne");
		accident.getWitnessTwo().setClassName("witnessTwo");
		if (accident.getLocations().length == 0) {
			errors.rejectValue("locations", "required", null, "Location is required.");
		}
		if (accident.getInjurylocations().length == 0 && StringUtils.isBlank(accident.getSpecInjLocation().getDescription())) {
			errors.rejectValue("injurylocations", "required", null, "Injury Location is required.");
		}
		if (accident.getSpecificLocation().isSpecEquipPiece()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "specificLocation.specEquipPieceDesc", "required", "Please specify equipment piece.");
		}
		if (accident.getSpecificLocation().isOther()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "specificLocation.otherDesc", "required", "Please specify other.");
		}
		wiv.validate(accident.getWitnessOne(), errors);
		wiv.validate(accident.getWitnessTwo(), errors);
	}

}
