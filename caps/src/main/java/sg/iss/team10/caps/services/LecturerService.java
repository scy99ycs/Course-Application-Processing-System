package sg.iss.team10.caps.services;

import java.util.ArrayList;

import sg.iss.team10.caps.model.Admin;
import sg.iss.team10.caps.model.Course;
import sg.iss.team10.caps.model.Lecturer;

public interface LecturerService {

	ArrayList<Lecturer> findAllLecturers();

	Lecturer findLecturerById(int staffId);

	Lecturer findLecturerByName(String staffName);
	
	ArrayList<Course> findCourseByLecturer(int staffId);

	Lecturer createLecturer(Lecturer lecturer);

	Lecturer updateLecturer(Lecturer lecturer);

	void removeLecturer(Lecturer lecturer);
	
	Lecturer authenticate(String username, String password);

	ArrayList<Integer> findAllIds();

	Integer findMaxStaffId();
}