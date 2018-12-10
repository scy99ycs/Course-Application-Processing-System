//package sg.iss.team10.caps.services;
//
//import java.util.ArrayList;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import sg.iss.team10.caps.model.SampleStudent;
//import sg.iss.team10.caps.repo.SampleStudentRepository;
//
//@Service
//public class SampleStudentServiceImpl implements SampleStudentService {
//
//	@Resource
//	SampleStudentRepository srepo;
//	
//	
//
//	@Override
//	@Transactional
//	public ArrayList<SampleStudent> findAllStudents() {
//		
//		return (ArrayList<SampleStudent>) srepo.findAll();
//	}
//
//	@Override
//	@Transactional
//	public SampleStudent findStudent(String nric) {
//		System.out.println("NRIC"+nric);
//		
//		SampleStudent student = srepo.findById(nric).get();
//		System.out.println(student.toString());
//		return student;
//
//	}
//
//	@Override
//	@Transactional
//	public SampleStudent createStudent(SampleStudent s) {
//		return srepo.saveAndFlush(s);
//	}
//
//	@Override
//	@Transactional
//	public SampleStudent updateStudent(SampleStudent s) {
//		return srepo.saveAndFlush(s);
//	}
//
//	@Override
//	@Transactional
//	public void removeStudent(SampleStudent s) {
//		srepo.delete(s);
//	}
//	
//	@Override
//	@Transactional
//	public ArrayList<SampleStudent> findStudentsByCriteria(SampleStudent student) {
//		return null;
//	}
//	
//	
//	
//
//}
