package sg.iss.team10.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.team10.caps.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
