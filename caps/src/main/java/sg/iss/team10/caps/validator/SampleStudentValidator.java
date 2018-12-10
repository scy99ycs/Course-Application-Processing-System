//package sg.iss.team10.caps.validator;
//
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//
//import sg.iss.team10.caps.model.SampleStudent;
//
//@Component
//public class SampleStudentValidator implements org.springframework.validation.Validator {
//
//	public SampleStudentValidator() {
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		// TODO Auto-generated method stub
//		return SampleStudent.class.isAssignableFrom(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors errors) {
//		// TODO Auto-generated method stub
//		SampleStudent s = (SampleStudent) target;
//		ValidationUtils.rejectIfEmpty(errors, "nric", "NRIC can be empty");
//		ValidationUtils.rejectIfEmpty(errors, "name", "Name cant be empty");
//	    System.out.println(s.toString());
//
//	}
//
//}
