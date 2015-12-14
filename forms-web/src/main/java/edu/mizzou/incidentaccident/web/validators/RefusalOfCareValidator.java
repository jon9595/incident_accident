package edu.mizzou.incidentaccident.web.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mizzou.incidentaccident.api.models.RefusalOfCareModel;
import edu.mizzou.incidentaccident.web.common.util.ValidationUtils;

public class RefusalOfCareValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(RefusalOfCareModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RefusalOfCareModel bean = (RefusalOfCareModel)target;
		if (StringUtils.isNotBlank(bean.getMemberSignature())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "refusalOfCare.staffSignature", "required", "Signature is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "refusalOfCare.dateStr", "required", "Date is required.");
		}
	}

}
