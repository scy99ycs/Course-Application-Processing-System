package sg.iss.team10.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.team10.caps.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	@Query("SELECT c FROM Course c where c.staffId =:id")
	ArrayList<Course> findCourseByStaffId(@Param("id") int id);
	
	@Query("SELECT c FROM Course c WHERE c.courseName=:name")
	Course findCourseByName(@Param("name") String name);
}
