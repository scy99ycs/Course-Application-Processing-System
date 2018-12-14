package sg.iss.team10.caps.services;

import java.util.ArrayList;


import sg.iss.team10.caps.model.Enrollment;


public interface EnrollmentService {

	
	
	ArrayList<Enrollment>findAllEnrollment ();
	
	ArrayList<Enrollment>findEnrollmentByStudentID (Integer studentID);
	
	ArrayList<Enrollment>findEnrollmentByCourseID (Integer CourseID);
	
	Integer findNumEnrolledByCourseID (Integer courseID);
	
	Enrollment createEnrollment(Enrollment e);

	Enrollment updateEnrollment(Enrollment e);
	
	Enrollment searchEnrollmentByEnrollmentId(Integer e);
	
	ArrayList<Integer> findAllEnrollmentID();
	
	void removeEnrollment(Enrollment e);
	
	Enrollment findEnrollmentById(Integer id);

	Integer findMaxEnrollmentId();

}