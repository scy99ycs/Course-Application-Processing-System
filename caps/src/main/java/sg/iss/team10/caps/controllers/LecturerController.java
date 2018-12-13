package sg.iss.team10.caps.controllers;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Cache;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.team10.caps.model.Course;
import sg.iss.team10.caps.model.Enrollment;
import sg.iss.team10.caps.model.Lecturer;
import sg.iss.team10.caps.model.Student;
import sg.iss.team10.caps.controllers.UserSession;
import sg.iss.team10.caps.services.CourseService;
import sg.iss.team10.caps.services.EnrollmentService;
import sg.iss.team10.caps.services.StudentService;
import sg.iss.team10.caps.util.CapsLogic;

@RequestMapping("/lecturer")
@Controller
public class LecturerController {

	@Autowired
	private CourseService cService;
	@Autowired
	private StudentService sService;
	@Autowired
	private EnrollmentService eService;

	@RequestMapping(value = "/courselist", method = RequestMethod.GET)
	public ModelAndView courseListPage(HttpSession session) {
		int lcId = ((UserSession) session.getAttribute("USERSESSION")).getLecturer().getStaffId();
		ModelAndView mav = new ModelAndView("LecturerCoursesTaught");
		ArrayList<Course> CourseList = cService.findCourseByStaffId(lcId);
		
		// Get current enrollment per course
		ArrayList<Integer> numEnrolled = new ArrayList<Integer>();
		for (Course current : CourseList) {
			numEnrolled.add(eService.findNumEnrolledByCourseID(current.getCourseId()));
		}
		mav.addObject("CourseList", CourseList);
		mav.addObject("numEnrolled", numEnrolled);
		return mav;
	}

	@RequestMapping(value = "/studentlist/{courseId}", method = RequestMethod.GET)
	public ModelAndView studentListPage(@PathVariable("courseId") int courseId) {
		ArrayList<Enrollment> enrollmentList = eService.findEnrollmentByCourseID(courseId);
		Course course = cService.findCourseById(courseId);

		// Get Student names
		ArrayList<String> firstNames = new ArrayList<String>();
		ArrayList<String> lastNames = new ArrayList<String>();
		ArrayList<Character> grades = new ArrayList<Character>();

		for (Enrollment current : enrollmentList) {
			Student student = sService.findStudentByStudentID(current.getStudentId());
			firstNames.add(student.getFirstMidName());
			lastNames.add(student.getLastName());
			grades.add(CapsLogic.calculateGrade(current.getScore()));
		}

		ModelAndView mav = new ModelAndView("LecturerEnrollmentList");
		mav.addObject("enrollmentList", enrollmentList);
		mav.addObject("course", course);
		mav.addObject("firstNames", firstNames);
		mav.addObject("lastNames", lastNames);
		mav.addObject("grades", grades);
		return mav;
	}

	@RequestMapping(value = "/grade/{enrollmentId}", method = RequestMethod.GET)
	public ModelAndView editGrade(@PathVariable("enrollmentId") int enrollmentId) {
		Enrollment enrollment = eService.searchEnrollmentByEnrollmentId(enrollmentId);
		Lecturer lecturer = new Lecturer();
		ModelAndView mav = new ModelAndView("LecturerGradeEdit");
		mav.addObject("course", cService.findCourseById(enrollment.getCourseId()));
		mav.addObject("student", sService.findStudentByStudentID(enrollment.getStudentId()));
		mav.addObject("enrollment", enrollment);
		return mav;
	}

	@RequestMapping(value = "/grade", method = RequestMethod.POST)
	public ModelAndView editUserPage(@Valid @ModelAttribute("enrollment") Enrollment enrollment, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		String message;

		if (result.hasErrors())
			message = "Oops! Unsuccessful grade update...Try again?";
		else {
			eService.updateEnrollment(enrollment);
			message = "Successful grade update!";
		}
		ModelAndView mav = new ModelAndView("redirect:/lecturer/studentlist/" + enrollment.getCourseId());
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/performance/{studentId}", method = RequestMethod.GET)
	public ModelAndView studentperformancePage(@PathVariable("studentId") int studentId) {

		Student student = sService.findStudentByStudentID(studentId);
		ArrayList<Enrollment> performanceList = eService.findEnrollmentByStudentID(studentId);
		ArrayList<Course> course = new ArrayList<Course>();
		ArrayList<Character> grade = new ArrayList<Character>();

		for (Enrollment current : performanceList) {
			course.add(cService.findCourseById(current.getCourseId()));
			grade.add(CapsLogic.calculateGrade(current.getScore()));
		}

		ModelAndView mav = new ModelAndView("LecturerStudentPerformance");
		mav.addObject("student", student);
		mav.addObject("performanceList", performanceList);
		mav.addObject("course", course);
		mav.addObject("grade", grade);
		return mav;
	}

	@RequestMapping(value = "/performance", method = RequestMethod.GET)
	public ModelAndView studentListPage() {
		ModelAndView mav = new ModelAndView("LecturerStudentList");
		ArrayList<Student> StudentList = sService.findAllStudents();
		mav.addObject("StudentList", StudentList);
		return mav;
	}
}