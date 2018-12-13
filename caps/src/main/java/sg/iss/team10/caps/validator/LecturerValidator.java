package sg.iss.team10.caps.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.team10.caps.model.Lecturer;

public class LecturerValidator implements Validator {

	public LecturerValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
        Lecturer lecturer =(Lecturer) target;
        ValidationUtils.rejectIfEmpty(errors,"staffId","staffId cant be blank");
        ValidationUtils.rejectIfEmpty(errors,"staffName","staffName cant be blank");
        ValidationUtils.rejectIfEmpty(errors,"password","password cant be blank");
        ValidationUtils.rejectIfEmpty(errors,"username","username cant be blank");
        System.out.println(lecturer.toString());
	}

}
