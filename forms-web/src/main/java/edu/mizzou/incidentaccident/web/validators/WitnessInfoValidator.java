package edu.mizzou.incidentaccident.web.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mizzou.incidentaccident.api.models.WitnessInfoModel;
import edu.mizzou.incidentaccident.web.common.util.ValidationUtils;

public class WitnessInfoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(WitnessInfoModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WitnessInfoModel bean = (WitnessInfoModel)target;
		String className = bean.getClassName();
		if (StringUtils.isNotBlank(bean.getName())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, className+".phone", "required", "Witness phone is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, className+".signature", "required", "Witness signature is required.");
		}
		if (StringUtils.isNotBlank(bean.getSignature())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, className+".phone", "required", "Witness phone is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, className+".name", "required", "Witness name is required.");
		}
		if (StringUtils.isNotBlank(bean.getPhone())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, className+".signature", "required", "Witness signature is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, className+".name", "required", "Witness name is required.");
		}
	}

}
