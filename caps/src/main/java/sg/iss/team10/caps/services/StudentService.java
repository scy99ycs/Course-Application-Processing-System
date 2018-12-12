package sg.iss.team10.caps.services;

import java.util.ArrayList;

import sg.iss.team10.caps.model.Student;

public interface StudentService {

	ArrayList<Student> findAllStudents();

	Student findStudentByStudentID(Integer studentId);
	
	ArrayList<Student> findStudentByLastName(String lastName);
	
	ArrayList<Student> findStudentByFirstMidName(String FirstMidName);
	
	Student findStudentByUserName(String userName);

	Student createStudent(Student s);

	Student updateStudent(Student s);

	void removeStudent(Student s);
	ArrayList<Integer> findAllStudentsId();
	
	Student authenticate(String username, String password);

}
