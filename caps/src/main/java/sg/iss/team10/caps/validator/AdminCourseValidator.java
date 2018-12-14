package sg.iss.team10.caps.validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.team10.caps.model.Course;

@Component
public class AdminCourseValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Course.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Course course = (Course) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courseName", "error.courseName", "Valid Course name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "capacity", "error.capacity", "Valid Capacity is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "credit", "error.credit", "Valid Credit is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duration", "error.duration", "Valid Duration is required.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "error.startDate", "Valid Start date is required.");
				
	}
	

	
}