package sg.iss.team10.caps.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.team10.caps.model.Course;
import sg.iss.team10.caps.model.Student;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	@Query("SELECT c FROM Course c where c.staffId =:id")
	ArrayList<Course> findCourseByStaffId(@Param("id") int id);
	
	@Query("SELECT c FROM Course c WHERE c.courseName =:name")
	Course findCourseByName(@Param("name") String name);
	
	@Query("SELECT c FROM Course c where c.courseId =:id")
	Course findCourseById(@Param("id") int id);
	
	@Query("SELECT c.courseId FROM Course c")
	ArrayList<Integer> findallCourseIds();
	
	@Query("SELECT c from Course c where c.courseName LIKE %:name%")
	ArrayList<Course> findCoursesByName(@Param("name") String name);
	
}