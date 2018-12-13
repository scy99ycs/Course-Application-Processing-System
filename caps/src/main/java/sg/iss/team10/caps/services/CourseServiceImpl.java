package sg.iss.team10.caps.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team10.caps.model.Course;
import sg.iss.team10.caps.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Resource
	private CourseRepository courseRepository;
	
	@Override
	@Transactional
	public void removeCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.delete(course);
	}

	@Override
	@Transactional
	public Course changeCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.saveAndFlush(course);
	}

	@Override
	@Transactional
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.saveAndFlush(course);
	}

	@Override
	@Transactional
	public ArrayList<Course> findAllCourse() {
		// TODO Auto-generated method stub
		ArrayList<Course> findall= (ArrayList<Course>)courseRepository.findAll();
		return findall;
	}
	
	@Override
	@Transactional
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return courseRepository.findCourseByName(name);
	}

	@Override
	@Transactional
	public ArrayList<Course> findCourseByStaffId(Integer sid) {
		// TODO Auto-generated method stub
		return (ArrayList<Course>)courseRepository.findCourseByStaffId(sid);
	}
	
	@Override
	@Transactional
	public Course findCourseById(Integer id) {
		// TODO Auto-generated method stub
		return courseRepository.findCourseById(id);
	}

	@Override
	public ArrayList<Integer> findAllCourseIds() {
		// TODO Auto-generated method stub
		return courseRepository.findallCourseIds();
	}

	@Override
	public ArrayList<Course> findCoursesByName(String name) {
		// TODO Auto-generated method stub
		return courseRepository.findCoursesByName(name);
	}

}