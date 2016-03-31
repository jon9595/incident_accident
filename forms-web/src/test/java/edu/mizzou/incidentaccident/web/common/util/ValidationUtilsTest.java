package edu.mizzou.incidentaccident.web.common.util;

import javax.annotation.Generated;

import org.junit.Test;
import org.springframework.validation.Errors;

@Generated(value = "org.junit-tools-1.0.2")
public class ValidationUtilsTest {

	private ValidationUtils createTestSubject() {
		return new ValidationUtils();
	}

	@MethodRef(name = "rejectIfDifferent", signature = "(QErrors;QString;QString;QString;)V")
	@Test
	public void testRejectIfDifferent() throws Exception {
		Errors errors = null;
		String field1 = "";
		String field2 = "";
		String errorCode = "";

		// default test
		ValidationUtils.rejectIfDifferent(errors, field1, field2, errorCode);
	}

	@MethodRef(name = "rejectIfDifferent", signature = "(QErrors;QString;QString;QString;QString;)V")
	@Test
	public void testRejectIfDifferent_1() throws Exception {
		Errors errors = null;
		String field1 = "";
		String field2 = "";
		String errorCode = "";
		String defaultMessage = "";

		// default test
		ValidationUtils.rejectIfDifferent(errors, field1, field2, errorCode,
				defaultMessage);
	}

	@MethodRef(name = "rejectIfDifferent", signature = "(QErrors;QString;QString;QString;[QObject;)V")
	@Test
	public void testRejectIfDifferent_2() throws Exception {
		Errors errors = null;
		String field1 = "";
		String field2 = "";
		String errorCode = "";
		Object[] errorArgs = new Object[] { null };

		// default test
		ValidationUtils.rejectIfDifferent(errors, field1, field2, errorCode,
				errorArgs);
	}

	@MethodRef(name = "rejectIfDifferent", signature = "(QErrors;QString;QString;QString;[QObject;QString;)V")
	@Test
	public void testRejectIfDifferent_3() throws Exception {
		Errors errors = null;
		String field1 = "";
		String field2 = "";
		String errorCode = "";
		Object[] errorArgs = new Object[] { null };
		String defaultMessage = "";

		// default test
		ValidationUtils.rejectIfDifferent(errors, field1, field2, errorCode,
				errorArgs, defaultMessage);
	}

	@MethodRef(name = "rejectIfNotEmail", signature = "(QErrors;QString;QString;)V")
	@Test
	public void testRejectIfNotEmail() throws Exception {
		Errors errors = null;
		String field = "";
		String errorCode = "";

		// default test
		ValidationUtils.rejectIfNotEmail(errors, field, errorCode);
	}

	@MethodRef(name = "rejectIfNotEmail", signature = "(QErrors;QString;QString;QString;)V")
	@Test
	public void testRejectIfNotEmail_1() throws Exception {
		Errors errors = null;
		String field = "";
		String errorCode = "";
		String defaultMessage = "";

		// default test
		ValidationUtils.rejectIfNotEmail(errors, field, errorCode,
				defaultMessage);
	}

	@MethodRef(name = "rejectIfNotEmail", signature = "(QErrors;QString;QString;[QObject;)V")
	@Test
	public void testRejectIfNotEmail_2() throws Exception {
		Errors errors = null;
		String field = "";
		String errorCode = "";
		Object[] errorArgs = new Object[] { null };

		// default test
		ValidationUtils.rejectIfNotEmail(errors, field, errorCode, errorArgs);
	}

	@MethodRef(name = "rejectIfNotEmail", signature = "(QErrors;QString;QString;[QObject;QString;)V")
	@Test
	public void testRejectIfNotEmail_3() throws Exception {
		Errors errors = null;
		String field = "";
		String errorCode = "";
		Object[] errorArgs = new Object[] { null };
		String defaultMessage = "";

		// default test
		ValidationUtils.rejectIfNotEmail(errors, field, errorCode, errorArgs,
				defaultMessage);
	}

	@MethodRef(name = "rejectIfZero", signature = "(QErrors;QString;QString;)V")
	@Test
	public void testRejectIfZero() throws Exception {
		Errors errors = null;
		String field = "";
		String errorCode = "";

		// default test
		ValidationUtils.rejectIfZero(errors, field, errorCode);
	}

	@MethodRef(name = "rejectIfZero", signature = "(QErrors;QString;QString;QString;)V")
	@Test
	public void testRejectIfZero_1() throws Exception {
		Errors errors = null;
		String field = "";
		String errorCode = "";
		String defaultMessage = "";

		// default test
		ValidationUtils.rejectIfZero(errors, field, errorCode, defaultMessage);
	}

	@MethodRef(name = "rejectIfZero", signature = "(QErrors;QString;QString;[QObject;)V")
	@Test
	public void testRejectIfZero_2() throws Exception {
		Errors errors = null;
		String field = "";
		String errorCode = "";
		Object[] errorArgs = new Object[] { null };

		// default test
		ValidationUtils.rejectIfZero(errors, field, errorCode, errorArgs);
	}

	@MethodRef(name = "rejectIfZero", signature = "(QErrors;QString;QString;[QObject;QString;)V")
	@Test
	public void testRejectIfZero_3() throws Exception {
		Errors errors = null;
		String field = "";
		String errorCode = "";
		Object[] errorArgs = new Object[] { null };
		String defaultMessage = "";

		// default test
		ValidationUtils.rejectIfZero(errors, field, errorCode, errorArgs,
				defaultMessage);
	}
}