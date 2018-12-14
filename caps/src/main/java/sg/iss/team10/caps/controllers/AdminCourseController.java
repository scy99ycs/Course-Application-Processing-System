package sg.iss.team10.caps.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import sg.iss.team10.caps.model.Student;
import sg.iss.team10.caps.services.CourseService;
import sg.iss.team10.caps.services.LecturerService;
import sg.iss.team10.caps.validator.AdminCourseValidator;

@RequestMapping(value = "/admin/course")
@Controller
public class AdminCourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private LecturerService lService;

	@Autowired
	private AdminCourseValidator courseValidator;

	@InitBinder("course")
	private void initCourseBinder(WebDataBinder binder) {
		binder.addValidators(courseValidator);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView newAddCoursePage(HttpSession session) {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		ModelAndView mav = new ModelAndView("AdminAddCourse", "course", new Course());
		mav.addObject("sidList", lService.findAllIds());
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addNewCourse(@ModelAttribute @Valid Course course, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		String message = "";
		CharSequence nums = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9";
		CharSequence alpha = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
		if (result.hasErrors()){
			ModelAndView mav = new ModelAndView("AdminAddCourse", "message", message);
			message = "Please enter Valid Data .";
			mav.addObject("sidList", lService.findAllIds());
			return mav;
		}
//		if (!(course.getCourseName().contains(nums) && course.getDuration().contains(alpha))) {
//			if (courseService.findCourseByStaffId(course.getStaffId()) != null) {
				ModelAndView mav = new ModelAndView();
				message = "New course " + course.getCourseName() + " was successfully created.";
				courseService.createCourse(course);
				mav.setViewName("redirect:/admin/course/list");
				mav.addObject("sidList", lService.findAllIds());
				redirectAttributes.addFlashAttribute("message", message);
				return mav;
//			} else {
//				message = "Please enter Valid Data .";
//				return new ModelAndView("AdminAddCourse", "message", message);
//			}
//		} else {
//			message = "Please enter Valid Data .";
//			return new ModelAndView("AdminAddCourse", "message", message);
//		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView viewAllCourse(HttpSession session) {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		ModelAndView mav = new ModelAndView("AdminCourseList");
		List<Course> courseList = courseService.findAllCourse();
		mav.addObject("courseList", courseList);
		return mav;
	}
	

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView studentListPage(HttpServletRequest request) 
	{
		
		String searchDetail = request.getParameter("sname");
		ArrayList<Course> courseList = courseService.findCoursesByName(searchDetail);
		String message = courseList.size() + " search result(s) for \""+ searchDetail + "\"";
		
		ModelAndView mav = new ModelAndView("AdminCourseList");
		mav.addObject("courseList", courseList);
		mav.addObject("message", message);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCoursePage(@PathVariable Integer id, HttpSession session) {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		ModelAndView mav = new ModelAndView("AdminEditCourse");
		Course course = courseService.findCourseById(id);
		mav.addObject("sidList", lService.findAllIds());
		mav.addObject("course", course);
		return mav;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editCourse(@ModelAttribute @Valid Course course, BindingResult result, @PathVariable String id,
			final RedirectAttributes redirectAttributes) {
		String message = "";
		CharSequence nums = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9";
		CharSequence alpha = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";

		if (result.hasErrors()){
			message = "Please enter Valid Data .";
			return new ModelAndView("AdminEditEnrollment", "message", message);
		}
//		if (!(course.getCourseName().contains(nums) && course.getDuration().contains(alpha))) {
//			if (courseService.findCourseByStaffId(course.getStaffId()) != null) {
				ModelAndView mav = new ModelAndView("redirect:/admin/course/list");
				message = "Course was successfully updated.";

				courseService.changeCourse(course);

				redirectAttributes.addFlashAttribute("message", message);
				return mav;
//			} else {
//				message = "Please enter Valid Data .";
//				return new ModelAndView("AdminEditCourse", "message", message);
//			}
//		} else {
//			message = "Please enter Valid Data .";
//			return new ModelAndView("AdminEditCourse", "message", message);
//		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDepartment(@PathVariable Integer id, final RedirectAttributes redirectAttributes,
			HttpSession session) {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		ModelAndView mav = new ModelAndView("redirect:/admin/course/list");
		Course course = courseService.findCourseById(id);
		courseService.removeCourse(course);
		String message = "The course " + id + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}