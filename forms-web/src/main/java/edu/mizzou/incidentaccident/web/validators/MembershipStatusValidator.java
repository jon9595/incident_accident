package edu.mizzou.incidentaccident.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mizzou.incidentaccident.api.models.MembershipStatusModel;
import edu.mizzou.incidentaccident.web.common.util.ValidationUtils;

@Component
public class MembershipStatusValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(MembershipStatusModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MembershipStatusModel bean = (MembershipStatusModel)target;
		if (bean.getMembership().length == 0) {
			errors.rejectValue("membershipStatus.membership", "required", null, "Membership Status is required.");
		} else if (bean.isOther()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "membershipStatus.otherExplain", "required", "Please explain Other.");
		} else if (bean.isGuest()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "membershipStatus.guestExplain", "required", "Please explain Guest Details.");
		}

	}

}
