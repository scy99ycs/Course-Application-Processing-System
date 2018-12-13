package sg.iss.team10.caps.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.team10.caps.model.Admin;

@Component
public class AdminLoginValidator implements Validator {

	public AdminLoginValidator() {
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Admin.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Admin admin = (Admin) target;
		// ValidationUtils.rejectIfEmpty(errors, "username", "Username cannot be
		// empty");
		// ValidationUtils.rejectIfEmpty(errors, "password", "Password cannot be
		// empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.admin.username", "Username cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.admin.password", "Password cannot be empty.");

		System.out.println(admin.toString());

	}

}