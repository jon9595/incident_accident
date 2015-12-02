package edu.mizzou.incidentaccident.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mizzou.incidentaccident.api.models.ProgramActivityInvolvedModel;
import edu.mizzou.incidentaccident.web.common.util.ValidationUtils;

@Component
public class ProgramActivityValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ProgramActivityInvolvedModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProgramActivityInvolvedModel bean = (ProgramActivityInvolvedModel)target;
		if (bean.getProgramActivity().length == 0) {
			errors.rejectValue("programActivity.programActivity", "required", null, "Program or Activity Involved is required.");
		} else {
			if(bean.isInformalActivity()) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "programActivity.infActDesc", "required", "Please Explain.");
			}
			if (bean.isClubRecSports()) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "programActivity.clubRecTeamName", "required", "Please specify club team name.");
			}
			if (bean.isRecSports()) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "programActivity.recTeamName", "required", "Please specify rec team name.");
			}
			if (bean.isSwimTeamPractice()) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "programActivity.swimTeamName", "required", "Please specify swim team name.");
			}
			if (bean.isTigerxPt()) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "programActivity.tigerxPrgName", "required", "Please specify program name.");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "programActivity.tigerxPtInstructor", "required", "Please specify instructor name.");
			}
			if (bean.isSpecEvt()) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "programActivity.specEvtGroup", "required", "Please specify group name.");
			}
		}
	}

}
