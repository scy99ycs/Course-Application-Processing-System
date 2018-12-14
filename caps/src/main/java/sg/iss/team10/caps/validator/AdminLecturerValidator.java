package sg.iss.team10.caps.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.team10.caps.model.Lecturer;

@Component
public class AdminLecturerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Lecturer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Lecturer lecturer= (Lecturer) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "staffName", "error.staffName", "Valid staff name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation", "error.designation", "Valid designation is required.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "Valid username is required.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Valid password is required.");
		
		System.out.println(lecturer.toString());
	}

	
}
