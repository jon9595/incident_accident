package edu.mizzou.incidentaccident.web.validators;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mizzou.incidentaccident.api.common.util.DateUtil;
import edu.mizzou.incidentaccident.api.models.DemographicsModel;
import edu.mizzou.incidentaccident.web.common.util.ValidationUtils;

@Component
public class DemographicsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(DemographicsModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DemographicsModel bean = (DemographicsModel)target;
		Date today = new Date();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "demographics.date", "required", "Date is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "demographics.time", "required", "Time is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "demographics.name", "required", "Name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "demographics.address", "required", "Address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "demographics.email", "required", "Email is required.");
		ValidationUtils.rejectIfNotEmail(errors, "demographics.email", "required", "Not a valid email address.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "demographics.phone", "required", "Phone Number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "demographics.birthDate", "required", "Birth Date is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "demographics.gender", "required", "Gender is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "demographics.resLifeStudent", "required", "Res Life Student is required.");
		if (bean.getDate()!=null && today.compareTo(bean.getDate()) < 0) {
			errors.rejectValue("demographics.date", "required", null, "This date is in the future.");
		}
		if (bean.getBirthDate()!=null && today.compareTo(bean.getBirthDate()) < 0) {
			errors.rejectValue("demographics.birthDate", "required", null, "This date is in the future.");
		}

	}

}
