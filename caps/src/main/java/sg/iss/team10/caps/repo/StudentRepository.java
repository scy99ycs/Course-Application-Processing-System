package sg.iss.team10.caps.repo;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team10.caps.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	//Display all Course Details first
	@Modifying(clearAutomatically=true)
	@Query("SELECT s from Student s")
	ArrayList<Student> findAllStudent();
	
	//Filter Course Details by course ID, course Name, credit, startDate
	@Query("SELECT s from Student s where s.StudentId = :studentId")
	ArrayList<Student> findStudentByStudentID(@Param("studentId") Integer studentId);
	//Display All Details Upon Selection | DualFunction
	@Query("SELECT s from Student s where s.lastName LIKE %:lastName%")
	ArrayList<Student> findStudentByLastName(@Param("lastName") String lastName);
	
	@Query("SELECT s from Student s where s.firstMidName LIKE %:firstMidName%")
	ArrayList<Student> findStudentByFirstMidName(@Param("firstMidName") String firstMidName);
	
	@Query("SELECT s from Student s where s.username LIKE %:username%")
	ArrayList<Student> findStudentByUserName(@Param("username") String username);
	
	

	
	
	
	
	
	
	
	
	
}
