//package sg.iss.team10.caps.services;
//
//import java.util.ArrayList;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import sg.iss.team10.caps.model.SampleLecturer;
//import sg.iss.team10.caps.repo.SampleLecturerRepository;
//
//@Service
//public class SampleLecturerServiceImpl implements SampleLecturerService {
//
//	@Resource
//	SampleLecturerRepository lrepo;
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see sg.iss.demo.services.LecturerService#findAllLecturers()
//	 */
//	@Override
//	@Transactional
//	public ArrayList<SampleLecturer> findAllLecturers() {
//		return (ArrayList<SampleLecturer>) lrepo.findAll();
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see sg.iss.demo.services.LecturerService#findLecturerById()
//	 */
//	@Override
//	@Transactional
//	public SampleLecturer findLecturerById(String lnric) {
//		return lrepo.findById(lnric).get();
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see sg.iss.demo.services.LecturerService#findLecturersByCriteria()
//	 */
//	@Override
//	@Transactional
//	public ArrayList<SampleLecturer> findLecturersByCriteria(SampleLecturer l) {
//		
//		return null;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see sg.iss.demo.services.LecturerService#createLecturer(sg.iss.demo.model.
//	 * Lecturer)
//	 */
//	@Override
//	@Transactional
//	public int createLecturer(SampleLecturer l) {
//		return 0;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see sg.iss.demo.services.LecturerService#updateLecturer(sg.iss.demo.model.
//	 * Lecturer)
//	 */
//	@Override
//	@Transactional
//	public int updateLecturer(SampleLecturer l) {
//		return 0;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see sg.iss.demo.services.LecturerService#removeLecturer(sg.iss.demo.model.
//	 * Lecturer)
//	 */
//	@Override
//	@Transactional
//	public int removeLecturer(SampleLecturer l) {
//		return 0;
//	}
//
//}
