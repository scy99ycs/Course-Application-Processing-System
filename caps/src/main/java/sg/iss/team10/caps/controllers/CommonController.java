package sg.iss.team10.caps.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.team10.caps.model.Admin;
import sg.iss.team10.caps.model.Course;
import sg.iss.team10.caps.model.Lecturer;
import sg.iss.team10.caps.model.Student;
import sg.iss.team10.caps.services.AdminService;
import sg.iss.team10.caps.services.CourseService;
import sg.iss.team10.caps.services.LecturerService;
import sg.iss.team10.caps.services.StudentService;
import sg.iss.team10.caps.validator.AdminLoginValidator;
import sg.iss.team10.caps.validator.LecturerLoginValidator;
import sg.iss.team10.caps.validator.StudentLoginValidator;

@Controller
public class CommonController {

	@Autowired
	private AdminService aService;

	@Autowired
	private LecturerService lService;

	@Autowired
	private StudentService sService;

	@Autowired
	private CourseService cService;

	@Autowired
	private AdminLoginValidator aValidator;

	@InitBinder("admin")
	private void initAdminBinder(WebDataBinder binder) {
		binder.addValidators(aValidator);
	}

	@Autowired
	private LecturerLoginValidator lValidator;

	@InitBinder("lecturer")
	private void initLecturerBinder(WebDataBinder binder) {
		binder.addValidators(lValidator);
	}

	@Autowired
	private StudentLoginValidator sValidator;

	@InitBinder("student")
	private void initStudentBinder(WebDataBinder binder) {
		binder.addValidators(sValidator);
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {

		ModelAndView mav = new ModelAndView("Home");
		ArrayList<Course> cList = cService.findAllCourse();
		ArrayList<Lecturer> lecList = new ArrayList<Lecturer>();
		for (Course current : cList) {
			lecList.add(lService.findLecturerById(current.getStaffId()));
		}
		mav.addObject("courseList", cList);
		mav.addObject("lecList", lecList);
		return mav;
	}

	@RequestMapping(value = "/home", params = "search", method = RequestMethod.POST)
	public ModelAndView homeSearch(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("Home");
		String cName = request.getParameter("cName");
		if (cName != "") {
			ArrayList<Course> cList = cService.findCoursesByName(cName);
			ArrayList<Lecturer> lecList = new ArrayList<Lecturer>();
			for (Course current : cList) {
				lecList.add(lService.findLecturerById(current.getStaffId()));
			}
			String message = cList.size() + " search result(s) for \"" + cName + "\"";
			mav.addObject("courseList", cList);
			mav.addObject("lecList", lecList);
			mav.addObject("message", message);
		}
		return mav;
	}

	@RequestMapping(value = "/home", params = "clear", method = RequestMethod.POST)
	public ModelAndView homeClear() {
		ModelAndView mav = new ModelAndView("redirect:/home");
		return mav;
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String adminLogin(Model model) {
		model.addAttribute("admin", new Admin());
		return "AdminLogin";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ModelAndView adminAuthenticate(@ModelAttribute Admin admin, HttpSession session, BindingResult result) {

		String message = "Incorrect username or password!";
		ModelAndView mav = new ModelAndView("AdminLogin", "message", message);

		if (result.hasErrors())
			return mav;

		if (admin.getUsername() != "" && admin.getPassword() != "") {
			Admin ad = aService.authenticate(admin.getUsername(), admin.getPassword());
			if (ad == null) {
				return mav;
			} else {
				UserSession us = new UserSession();
				us.setSessionId(session.getId());
				us.setAdmin(ad);
				session.setAttribute("USERSESSION", us);
				session.setAttribute("USERNAME", ad.getAdminName());
				return new ModelAndView("redirect:/admin/student/list");
			}
		} else
			return new ModelAndView("AdminLogin", "message", "Please complete the form");
	}

	@RequestMapping(value = "/lecturerlogin", method = RequestMethod.GET)
	public String lecturerLogin(Model model) {
		model.addAttribute("lecturer", new Lecturer());
		return "LecturerLogin";
	}

	@RequestMapping(value = "/lecturerlogin", method = RequestMethod.POST)
	public ModelAndView lecturerAuthenticate(@ModelAttribute Lecturer lecturer, HttpSession session,
			BindingResult result) {

		String message = "Incorrect username or password!";
		ModelAndView mav = new ModelAndView("LecturerLogin", "message", message);

		if (result.hasErrors())
			return mav;

		if (lecturer.getUsername() != "" && lecturer.getPassword() != "") {
			Lecturer lc = lService.authenticate(lecturer.getUsername(), lecturer.getPassword());
			if (lc == null) {
				return mav;
			} else {
				UserSession us = new UserSession();
				us.setSessionId(session.getId());
				us.setLecturer(lc);
				session.setAttribute("USERSESSION", us);
				session.setAttribute("USERNAME", lc.getStaffName());
				return new ModelAndView("redirect:/lecturer/courselist");
			}
		} else
			return new ModelAndView("LecturerLogin", "message", "Please complete the form");
	}

	@RequestMapping(value = "/studentlogin", method = RequestMethod.GET)
	public String studentLogin(Model model) {
		model.addAttribute("student", new Student());
		return "StudentLogin";
	}

	@RequestMapping(value = "/studentlogin", method = RequestMethod.POST)
	public ModelAndView studentAuthenticate(@ModelAttribute Student student, HttpSession session,
			BindingResult result) {

		String message = "Incorrect username or password!";
		ModelAndView mav = new ModelAndView("StudentLogin", "message", message);

		if (result.hasErrors())
			return mav;

		if (student.getUsername() != "" && student.getPassword() != "") {
			Student st = sService.authenticate(student.getUsername(), student.getPassword());
			if (st == null) {
				return mav;
			} else {
				UserSession us = new UserSession();
				us.setSessionId(session.getId());
				us.setStudent(st);
				session.setAttribute("USERSESSION", us);
				session.setAttribute("USERNAME", st.getLastName());
				return new ModelAndView("redirect:/student/landing");
			}
		} else
			return new ModelAndView("StudentLogin", "message", "Please complete the form");
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

	@RequestMapping(value = "/")
	public ModelAndView doDefault() {
		return new ModelAndView("redirect:/home");
	}

}
