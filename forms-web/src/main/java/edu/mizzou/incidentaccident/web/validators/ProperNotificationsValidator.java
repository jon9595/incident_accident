package edu.mizzou.incidentaccident.web.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mizzou.incidentaccident.api.models.ProperNotificationsModel;
import edu.mizzou.incidentaccident.web.common.util.ValidationUtils;

@Component
public class ProperNotificationsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ProperNotificationsModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProperNotificationsModel bean = (ProperNotificationsModel)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.profStaffContacted", "required", "Please specify if Prof Staff contacted.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.emsContacted", "required", "Please specify if EMS was contacted.");
		if ("Y".equals(bean.getEmsContacted())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.mupdOfficerName", "required", "Please specify the officer that responded.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.emsEntrance", "required", "Please specify the entrance EMS used.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.emsCalledStr", "required", "Please specify the time.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.emsArrivedStr", "required", "Please specify the time.");
			if(!"Y".equals(bean.getProfStaffContacted())) {
				errors.rejectValue("properNotifications.profStaffContacted", "required", null, "Professional Staff must be contacted.");
			}
		}
		if ("Y".equals(bean.getProfStaffContacted())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.profStaffName", "required", "Please specify staff member called.");
		}
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotificatons.reportFiledBy", "required", "Please specify who filed this report");
		
		if (StringUtils.isNotBlank(bean.getMupdOfficerName())) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.mupdOfficerCalledStr", "required", "Please provide a time.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.mupdOfficerArrivedStr", "required", "Please provide a time.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "properNotifications.mupdOfficerCaseNbr", "required", "Please provide a case number.");
		}
	}

}
