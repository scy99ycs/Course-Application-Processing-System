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
	public  Student findStudentByStudentID(Integer studentId) {
		System.out.println("StudentID"+studentId);	
		Student slist = srepo.findStudentByStudentID(studentId); 
		System.out.println(slist.toString());
		return slist;
	}
	
	@Override
	@Transactional
	public  ArrayList<Student> findStudentByLastName(String lastName) {
		System.out.println("LastName"+lastName);	
		ArrayList<Student> slist = srepo.findStudentByLastName(lastName); 
		for (Student current:slist)
		System.out.println(current.toString());
		return slist;
	}
	
	@Override
	@Transactional
	public  ArrayList<Student> findStudentByFirstMidName(String firstMidName) {
		System.out.println("FirstMidName"+firstMidName);	
		ArrayList<Student> slist = srepo.findStudentByLastName(firstMidName); 
		for (Student current:slist)
		System.out.println(current.toString());
		return slist;
	}
	
	@Override
	@Transactional
	public  Student findStudentByUserName(String userName) {
		System.out.println("UserName"+userName);	
		Student slist = srepo.findStudentByUserName(userName); 
		System.out.println(slist.toString());
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
	
}
