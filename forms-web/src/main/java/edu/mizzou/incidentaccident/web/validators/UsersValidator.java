package edu.mizzou.incidentaccident.web.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mizzou.incidentaccident.api.models.UsersModel;
import edu.mizzou.incidentaccident.api.models.WitnessInfoModel;
import edu.mizzou.incidentaccident.web.common.util.ValidationUtils;

@Component
public class UsersValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(UsersModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UsersModel bean = (UsersModel)target;
		validateCommonFields(target, errors);
	}

	public void validateCommonFields(Object target, Errors errors) {
		UsersModel bean = (UsersModel)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required", "First Name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required", "Last Name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "required", "Position is required.");
		if (StringUtils.isNotBlank(bean.getEmail())) {
			ValidationUtils.rejectIfNotEmail(errors, "email", "required", "Email address is not valid.");
		}
	}
	
	public void validateCreation(Object target, Errors errors) {
		UsersModel bean = (UsersModel)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required", "Username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required", "Password is required");
		ValidationUtils.rejectIfDifferent(errors, "password", "password2", "passwords.noMatch", "Passwords do not match.");
	}
	

	public void validatePasswordChange(Object target, Errors errors) {
		UsersModel user = (UsersModel)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPassword", "required", "Password is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required", "Password is required");
		ValidationUtils.rejectIfDifferent(errors, "password", "password2", "passwords.noMatch", "Passwords do not match.");
	}
}
