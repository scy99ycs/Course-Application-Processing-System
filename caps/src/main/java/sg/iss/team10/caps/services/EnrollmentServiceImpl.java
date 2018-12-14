package sg.iss.team10.caps.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team10.caps.model.Enrollment;
import sg.iss.team10.caps.repo.EnrollmentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Resource
	EnrollmentRepository srepo;
	
//ArrayList<Enrollment>findAllEnrollment ();
//	
//	ArrayList<Enrollment>findEnrollmentByStudentID (Integer studentID);
//	
//	ArrayList<Enrollment>findEnrollmentByCourseID (Integer CourseID);
	
	@Override
	@Transactional
	public ArrayList<Enrollment> findAllEnrollment() {
		
		return (ArrayList<Enrollment>) srepo.findAll();
	}
	
	@Override
	@Transactional
	public  ArrayList<Enrollment> findEnrollmentByStudentID(Integer studentID) {
		System.out.println("StudentID"+studentID);	
		ArrayList<Enrollment> slist = srepo.findEnrollmentByStudentID(studentID); 
		for (Enrollment current:slist)
		System.out.println(current.toString());
		return slist;
	}
	
	@Override
	@Transactional
	public  ArrayList<Enrollment> findEnrollmentByCourseID(Integer courseID) {
		System.out.println("CourseID"+ courseID);	
		ArrayList<Enrollment> slist = srepo.findEnrollmentByCourseID(courseID); 
		for (Enrollment current:slist)
		System.out.println(current.toString());
		return slist;
	}
	
	@Override
	@Transactional
	public Enrollment createEnrollment(Enrollment e) {
		return srepo.saveAndFlush(e);
	}
	
	@Override
	@Transactional
	public Enrollment updateEnrollment(Enrollment e) {
		return srepo.saveAndFlush(e);
	}

	@Override
	@Transactional
	public void removeEnrollment(Enrollment e) {
		srepo.delete(e);
	}
	
	@Override
	@Transactional
	public Enrollment searchEnrollmentByEnrollmentId(Integer eid) {
		Enrollment slist = srepo.findById(eid).get();
		return slist;
	}
	
	@Override
	@Transactional
	public ArrayList<Integer> findAllEnrollmentID() {
	ArrayList<Integer> slist = srepo.findAllEnrollmentID();
		return slist;
	

	
	
	//Display all Enrollment 
//			@Query(value = "SELECT * from Enrollment e ", nativeQuery = true)
//			ArrayList<Enrollment> findAllEnrollment(@Param("studentId") int studentid);
//			
//			@Query("SELECT e from Enrollment e where e.StudentId = :studentId")
//			ArrayList<Enrollment> findEnrollmentByStudentID(@Param("studentId") Integer studentId);
//			
//			@Query("SELECT e from Enrollment e where e.CourseId = :CourseId")
//			ArrayList<Enrollment> findEnrollmentByCourseID(@Param("CourseId") Integer CourseId);
	
	}
	
	@Override
	public Integer findNumEnrolledByCourseID(Integer courseID) {
		return findEnrollmentByCourseID(courseID).size();
	}

	@Override
	public Enrollment findEnrollmentById(Integer id) {
		// TODO Auto-generated method stub
		return srepo.findById(id).get();
	}
	@Override
	public Integer findMaxEnrollmentId() {
		// TODO Auto-generated method stub
		return srepo.findMaxEnrollmentId();
	}
}