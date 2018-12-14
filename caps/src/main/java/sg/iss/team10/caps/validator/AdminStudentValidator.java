package sg.iss.team10.caps.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.team10.caps.model.Student;

@Component
public class AdminStudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Student student= (Student) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstMidName", "error.firstMidName", "Valid Student name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Valid Last Name is required.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "enrollmentDate", "error.enrollmentDate", "Valid Enrollment Date is required.");
		
		System.out.println(student.toString());
	}

	
}
