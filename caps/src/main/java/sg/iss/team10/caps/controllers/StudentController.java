package sg.iss.team10.caps.controllers;

import java.util.ArrayList;
import java.util.List;

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
import sg.iss.team10.caps.services.CourseService;
import sg.iss.team10.caps.services.EnrollmentService;



@RequestMapping(value="/StudentLandingPage")
@Controller
public class StudentController {
	
	@Autowired
	private EnrollmentService eService;
	@Autowired
	private CourseService cService;
 	
// 	@InitBinder("department")
//	private void initDepartmentBinder(WebDataBinder binder) {
//		binder.addValidators(dValidator);
//	}
	/**
	 * DEPARTMENT CRUD OPERATIONS
	 * 
	 * @return
	 */

	@RequestMapping(value = "/StudentEnrollmentConfirm", method = RequestMethod.GET)
	public ModelAndView newEnrollmentPage() {
		ModelAndView mav = new ModelAndView("enrollment-new", "enrollment", new Enrollment());
		mav.addObject("eidlist", eService.findAllEnrollmentID());
		return mav;
	}

	@RequestMapping(value = "/StudentEnrollmentConfirm", method = RequestMethod.POST)
	public ModelAndView createNewDepartment(@ModelAttribute @Valid Enrollment enrollment, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("enrollment-new");

		ModelAndView mav = new ModelAndView();
		String message = "New enrollment " + enrollment.getEnrollmentId() + " was successfully created.";

		eService.createEnrollment(enrollment);
		mav.setViewName("redirect:/StudentLandingPage/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	// 1st Page
	@RequestMapping(value = "/StudentLandingPage", method = RequestMethod.GET)
	public ModelAndView StudentLandingPage(Integer studentId) {
		ModelAndView mav = new ModelAndView("CourseGrade-list");
		ArrayList<Enrollment> courseGradeList = eService.findEnrollmentByStudentID(studentId);
		mav.addObject("courseGradeList", courseGradeList);
		return mav;
	}
	//2.1 Page : findAllCourse
	@RequestMapping(value = "/StudentSearchCoursePage", method = RequestMethod.GET)
	public ModelAndView StudentSearchCoursePage() {
		ModelAndView mav = new ModelAndView("Course-list");
		ArrayList<Course> courseList = cService.findAllCourse();
		mav.addObject("courseList", courseList);
		return mav;
		
	}
	
	//2.2 Page : findCourseById
	@RequestMapping(value = "/StudentSearchCoursePage", method = RequestMethod.GET)
	public ModelAndView StudentSearchCoursePage(Integer courseId) {
		ModelAndView mav = new ModelAndView("Course-list");
		Course courseList = cService.findCourseById(courseId);
		mav.addObject("courseList", courseList);
		return mav;
		
	}
	//2.3 Page : FindCourseByName
	@RequestMapping(value = "/StudentSearchCoursePage", method = RequestMethod.GET)
	public ModelAndView StudentSearchCoursePage(String name) {
		ModelAndView mav = new ModelAndView("Course-list");
		Course courseList = cService.findCourseByName(name);
		mav.addObject("courseList", courseList);
		return mav;
		
	}
	
	//2.4 Page: findCourseByStaffId
	@RequestMapping(value = "/StudentSearchCoursePage", method = RequestMethod.GET)
	public ModelAndView findCourseByStaffId(Integer sid) {
		ModelAndView mav = new ModelAndView("Course-list");
		ArrayList<Course> courseList = cService.findCourseByStaffId(sid);
		mav.addObject("courseList", courseList);
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
