package sg.iss.team10.caps.validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.team10.caps.model.Course;
import sg.iss.team10.caps.model.Enrollment;

@Component
public class AdminEnrollmentValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Enrollment.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Enrollment enrollment= (Enrollment) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courseId", "error.courseId", "Valid Course Id is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentId", "error.studentId", "Valid Student Id is required.");
	}
	

	
}