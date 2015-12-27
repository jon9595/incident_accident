package edu.mizzou.incidentaccident.web.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mizzou.incidentaccident.api.models.ProperNotificationsModel;
import edu.mizzou.incidentaccident.web.common.util.ValidationUtils;

public class ResLifeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ProperNotificationsModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProperNotificationsModel bean = (ProperNotificationsModel)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.resLifeContEmailSent", "required", "Please specify if Email was sent.");
		if ("Y".equals(bean.getResLifeContEmailSent())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.resLifeContDateSentStr", "required", "Please specify a date.");
		}

	}

}
