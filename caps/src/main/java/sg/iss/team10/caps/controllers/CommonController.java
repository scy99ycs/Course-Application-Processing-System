package sg.iss.team10.caps.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import sg.iss.team10.caps.model.Lecturer;
import sg.iss.team10.caps.model.Student;
import sg.iss.team10.caps.services.AdminService;
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
	private AdminLoginValidator aValidator;

	@InitBinder("Admin")
	private void initAdminBinder(WebDataBinder binder) {
		binder.addValidators(aValidator);
	}

	@Autowired
	private LecturerLoginValidator lValidator;
	
	@InitBinder("Lecturer")
	private void initLecturerBinder(WebDataBinder binder) {
		binder.addValidators(lValidator);
	}
	
	@Autowired
	private StudentLoginValidator sValidator;
	
	@InitBinder("Student")
	private void initStudentBinder(WebDataBinder binder) {
		binder.addValidators(sValidator);
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "Home";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String adminLogin(Model model) {
		model.addAttribute("admin", new Admin());
		return "AdminLogin";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ModelAndView adminAuthenticate(@ModelAttribute @Valid Admin admin, HttpSession session,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		String message = null;
		ModelAndView mav = new ModelAndView("AdminLogin");
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("message", "false");
			return mav;
		}
		UserSession us = new UserSession();
		if (admin.getUsername() != null && admin.getPassword() != null) {
			Admin ad = aService.authenticate(admin.getUsername(), admin.getPassword());
			if (ad == null) {
				return mav;
			} else {
				us.setSessionId(session.getId());
				us.setAdmin(ad);
				mav = new ModelAndView("redirect:/admin/student/list");
			}
		} else {
			return mav;
		}
		session.setAttribute("USERSESSION", us);
		redirectAttributes.addFlashAttribute("message", "true");
		return mav;
	}

	@RequestMapping(value = "/lecturerlogin", method = RequestMethod.GET)
	public String lecturerLogin(Model model) {
		model.addAttribute("lecturer", new Lecturer());
		return "LecturerLogin";
	}

	@RequestMapping(value = "/lecturerlogin", method = RequestMethod.POST)
	public ModelAndView lecturerAuthenticate(@ModelAttribute Lecturer lecturer, HttpSession session,
			BindingResult result) {
		ModelAndView mav = new ModelAndView("LecturerLogin");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		if (lecturer.getUsername() != null && lecturer.getPassword() != null) {
			Lecturer lc = lService.authenticate(lecturer.getUsername(), lecturer.getPassword());
			if (lc == null) {
				return mav;
			} else {
				us.setSessionId(session.getId());
				us.setLecturer(lc);
				// to change after check with the relevant team
				mav = new ModelAndView("redirect:/lecturer/courselist");
			}
		} else {
			return mav;
		}
		session.setAttribute("USERSESSION", us);
		return mav;
	}

	@RequestMapping(value = "/studentlogin", method = RequestMethod.GET)
	public String studentLogin(Model model) {
		model.addAttribute("student", new Student());
		return "StudentLogin";
	}

	@RequestMapping(value = "/studentlogin", method = RequestMethod.POST)
	public ModelAndView studentAuthenticate(@ModelAttribute Student student, HttpSession session,
			BindingResult result) {
		ModelAndView mav = new ModelAndView("StudentLogin");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		if (student.getUsername() != null && student.getPassword() != null) {
			Student st = sService.authenticate(student.getUsername(), student.getPassword());
			if (st == null) {
				return mav;
			} else {
				us.setSessionId(session.getId());
				us.setStudent(st);
				// to change after check with the relevant team
				mav = new ModelAndView("redirect:/student/landing");
			}
		} else {
			return mav;
		}
		session.setAttribute("USERSESSION", us);
		return mav;
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

	// For testing after login, must delete after communicate with team
	@RequestMapping(value = "/testadmin", method = RequestMethod.GET)
	public String adminTest() {
		return "TestingAfterLoginAdmin";
	}
}
