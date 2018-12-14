package sg.iss.team10.caps.services;

import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.iss.team10.caps.model.Student;
import sg.iss.team10.caps.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	StudentRepository srepo;

	@Override
	@Transactional
	public ArrayList<Student> findAllStudents() {
		return (ArrayList<Student>) srepo.findAll();
	}

	@Override
	@Transactional
	public Student findStudentByStudentID(Integer studentId) {
		Student slist = srepo.findStudentByStudentID(studentId);
		return slist;
	}

	@Override
	@Transactional
	public ArrayList<Student> findStudentByLastName(String lastName) {
		ArrayList<Student> slist = srepo.findStudentByLastName(lastName);
		return slist;
	}

	@Override
	@Transactional
	public ArrayList<Student> findStudentByFirstMidName(String firstMidName) {
		ArrayList<Student> slist = srepo.findStudentByLastName(firstMidName);
		return slist;
	}

	@Override
	public ArrayList<Student> findStudentByFullName(String fullName) {
		ArrayList<Student> slist = srepo.findStudentByFullName(fullName);
		return slist;
	}
	
	@Override
	@Transactional
	public Student findStudentByUserName(String userName) {
		Student slist = srepo.findStudentByUserName(userName);
		return slist;
	}

	@Override
	@Transactional
	public Student createStudent(Student s) {
		return srepo.saveAndFlush(s);
	}

	@Override
	@Transactional
	public Student updateStudent(Student s) {
		return srepo.saveAndFlush(s);
	}

	@Override
	@Transactional
	public void removeStudent(Student s) {
		srepo.delete(s);
	}

	@Override
	@Transactional
	public Student authenticate(String username, String password) {
		return srepo.authenticate(username, password);
	}

	@Override
	public ArrayList<Integer> findAllStudentsId() {
		// TODO Auto-generated method stub
		return srepo.findAllIds();
		
	}

	@Override
	public Integer findMaxStudentId() {
		// TODO Auto-generated method stub
		return srepo.findMaxStudentId();
	}


}
