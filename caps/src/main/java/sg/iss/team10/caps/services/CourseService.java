package sg.iss.team10.caps.services;

import java.util.ArrayList;

import sg.iss.team10.caps.model.Course;

public interface CourseService {
	
	void removeCourse(Course course);
	Course changeCourse(Course course);
	Course createCourse(Course course);
	ArrayList<Course> findAllCourse();
	Course findCourseByName(String name);
	ArrayList<Course> findCourseByStaffId(Integer sid);
	Course findCourseById(Integer cid);
	ArrayList<Integer> findAllCourseIds();
	ArrayList<Course> findCoursesByName(String name);
}