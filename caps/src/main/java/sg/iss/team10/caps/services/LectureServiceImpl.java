package sg.iss.team10.caps.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.team10.caps.model.Admin;
import sg.iss.team10.caps.model.Course;
import sg.iss.team10.caps.model.Lecturer;
import sg.iss.team10.caps.repo.LecturerRepository;

@Service
public class LectureServiceImpl implements LecturerService {

	@Resource
	LecturerRepository lrepos;
	
	@Override
	public ArrayList<Lecturer> findAllLecturers() {
		return (ArrayList<Lecturer>) lrepos.findAll();
	}

	@Override
	public Lecturer findLecturerById(int staffId) {
		return lrepos.findLecturerById(staffId);
	}

	@Override
	public Lecturer findLecturerByName(String staffName) {
		return lrepos.findLecturerByName(staffName);
	}

	@Override
	public ArrayList<Course> findCourseByLecturer(int staffId) {
		return (ArrayList<Course>) lrepos.findLecturerById(staffId).getCourse();
	}

	@Override
	public Lecturer createLecturer(Lecturer lecturer) {
		return lrepos.saveAndFlush(lecturer);
	}

	@Override
	public Lecturer updateLecturer(Lecturer lecturer) {
		return lrepos.saveAndFlush(lecturer);
	}

	@Override
	public void removeLecturer(Lecturer lecturer) {
		lrepos.delete(lecturer);
	}
	
	@Override
	@Transactional
	public Lecturer authenticate(String username, String password) {
		return lrepos.authenticate(username, password);
	}

	@Override
	public ArrayList<Integer> findAllIds() {
		// TODO Auto-generated method stub
		return lrepos.findAllIds();
	}
	
	@Override
	public Integer findMaxStaffId() {
		// TODO Auto-generated method stub
		return lrepos.findMaxStaffId();
	}

}
