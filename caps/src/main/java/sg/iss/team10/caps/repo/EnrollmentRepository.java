package sg.iss.team10.caps.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team10.caps.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
	
	//Display all Enrollment 
		@Query(value = "SELECT * from Enrollment e ", nativeQuery = true)
		ArrayList<Enrollment> findAllEnrollment();
		
		@Query("SELECT e from Enrollment e where e.studentId = :studentId")
		ArrayList<Enrollment> findEnrollmentByStudentID(@Param("studentId") Integer studentId);
		
		@Query("SELECT e from Enrollment e where e.courseId = :CourseId")
		ArrayList<Enrollment> findEnrollmentByCourseID(@Param("CourseId") Integer CourseId);
		
		@Query("SELECT e from Enrollment e where e.enrollmentId = :enrollmentId")
		Enrollment findEnrollmentByEnrollmentID(@Param("enrollmentId") Integer enrollmentId);

		@Query("SELECT DISTINCT e.enrollmentId FROM Enrollment e")
		ArrayList<Integer> findAllEnrollmentID();
		
		@Query("SELECT MAX(enrollmentId) FROM Enrollment")
		Integer findMaxEnrollmentId();
		
}