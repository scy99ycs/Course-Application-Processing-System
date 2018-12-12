package sg.iss.team10.caps.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.team10.caps.model.Course;
import sg.iss.team10.caps.model.Enrollment;
import sg.iss.team10.caps.model.Student;
import sg.iss.team10.caps.services.CourseService;
import sg.iss.team10.caps.services.EnrollmentService;
import sg.iss.team10.caps.services.StudentService;


@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private EnrollmentService eService;
	@Autowired
	private CourseService cService;
 	@Autowired
 	private StudentService sService;
// 	@InitBinder("department")
//	private void initDepartmentBinder(WebDataBinder binder) {
//		binder.addValidators(dValidator);
//	}
	/**
	 * DEPARTMENT CRUD OPERATIONS
	 * 
	 * @return
	 */
 	
 	

	//Creation after Confirmation
	@RequestMapping(value = "/create/{courseId}", method = RequestMethod.GET)
	public ModelAndView newEnrollmentPage(@PathVariable("courseId") Integer courseId) {
		ModelAndView mav = new ModelAndView("enrollmentnew", "enrollment", new Enrollment());
		Course course = cService.findCourseById(courseId);
		mav.addObject("course", course);
		//mav.addObject("eidlist", eService.findAllEnrollmentID());
		return mav;
		
	}

	
	@RequestMapping(value = "/create/{CourseID}", method = RequestMethod.POST)
	public ModelAndView createNewEnrollment(@ModelAttribute @Valid Enrollment enrollment, BindingResult result, final RedirectAttributes redirectAttributes, @PathVariable("courseId") Integer courseId) /*throw*/ {

		if (result.hasErrors())
			return new ModelAndView("enrollmentnew");

		ModelAndView mav = new ModelAndView();
		//HttpSession session
		//BindingResult result,
		//String message = "New enrollment " + enrollment.getEnrollmentId() + " was successfully created.";
		//Student s= (Student)session.getAttribute("USERSESSION");
		//enrollment.setStudentId(s.getStudentId());
		enrollment.setStudentId(5);
		enrollment.setCourseId(courseId);
		enrollment.setEnrollmentId(16);
		eService.createEnrollment(enrollment);
		mav.setViewName("redirect:/student/search");
		//redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	// 1st Page to be displayed when Student log in through ID
	@RequestMapping(value = "/landing", method = RequestMethod.GET)
	public ModelAndView StudentLandingPage(Integer studentId) {
		ModelAndView mav = new ModelAndView("enrollmentlist");
		ArrayList<Enrollment> GradeList = eService.findEnrollmentByStudentID(studentId);
		mav.addObject("GradeList", GradeList);
		return mav;
	}
	//2.1 Page : findAllCourse 
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView StudentSearchCoursePage() {
		ModelAndView mav = new ModelAndView("StudentSearchList");
		ArrayList<Course> courseList = cService.findAllCourse();
		mav.addObject("courseList", courseList);
		return mav;		
	}
	
	//2.2 Page : findCourseById
	@RequestMapping(value = "/SearchById", method = RequestMethod.GET)
	public ModelAndView StudentSearchCoursePageById(Integer courseId) {
		ModelAndView mav = new ModelAndView("courseId");
		Course course = cService.findCourseById(courseId);
		mav.addObject("courseId", course);
		return mav;
		
	}
	//2.3 Page : FindCourseByName
	@RequestMapping(value = "/SearchByName", method = RequestMethod.GET)
	public ModelAndView StudentSearchCourseByName(String name) {
		ModelAndView mav = new ModelAndView("courseName");
		Course course = cService.findCourseByName(name);
		mav.addObject("courseName", course);
		return mav;
		
	}
	
	//2.4 Page: findCourseByStaffId
	@RequestMapping(value = "/SearchByStaff", method = RequestMethod.GET)
	public ModelAndView findCourseByStaffId(Integer sid) {
		ModelAndView mav = new ModelAndView("courseStaff");
		ArrayList<Course> courseList = cService.findCourseByStaffId(sid);
		mav.addObject("courseStaffList", courseList);
		return mav;
		
	}
	
	
	
	
	
		
	
	
	
	



//	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//	public ModelAndView editDepartmentPage(@PathVariable String id) {
//		ModelAndView mav = new ModelAndView("department-edit");
//		Department department = dService.findDepartment(id);
//		mav.addObject("department", department);
//		mav.addObject("eidlist", eService.findAllEmployeeIDs());
//		return mav;
//	}
//
//	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
//	public ModelAndView editDepartment(@ModelAttribute @Valid Department department, BindingResult result,
//			@PathVariable String id, final RedirectAttributes redirectAttributes) throws DepartmentNotFound {
//
//		if (result.hasErrors())
//			return new ModelAndView("department-edit");
//
//		ModelAndView mav = new ModelAndView("redirect:/admin/department/list");
//		String message = "Department was successfully updated.";
//
//		dService.changeDepartment(department);
//
//		redirectAttributes.addFlashAttribute("message", message);
//		return mav;
//	}
//
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//	public ModelAndView deleteDepartment(@PathVariable String id, final RedirectAttributes redirectAttributes)
//			throws DepartmentNotFound {
//
//		ModelAndView mav = new ModelAndView("redirect:/admin/department/list");
//		Department department = dService.findDepartment(id);
//		dService.removeDepartment(department);
//		String message = "The department " + department.getDepartmentId() + " was successfully deleted.";
//
//		redirectAttributes.addFlashAttribute("message", message);
//		return mav;
//	}

}
