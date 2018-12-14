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

import sg.iss.team10.caps.model.Student;
import sg.iss.team10.caps.services.StudentService;
import sg.iss.team10.caps.validator.AdminStudentValidator;

@RequestMapping(value = "/admin/student")
@Controller
public class AdminStudentController {

	@Autowired
	private StudentService sService;
	@Autowired
	private AdminStudentValidator aValidator;

	@InitBinder("student")
	private void initStudentBinder(WebDataBinder binder) {
		binder.addValidators(aValidator);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView newAddStudentPage(HttpSession session) {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		ModelAndView mav = new ModelAndView("AdminAddStudent", "student", new Student());
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@ModelAttribute @Valid Student student, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		String message = "";
		CharSequence nums = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9";

		if (result.hasErrors())
			return new ModelAndView("AdminAddStudent");

		ModelAndView mav = new ModelAndView();
		if (!(student.getFirstMidName().contains(nums) || student.getLastName().contains(nums))) {

			message = "New Student " + (sService.findMaxStudentId() + 1) + " was successfully created.";
			String username = "S" + value(sService.findMaxStudentId() + 1) + student.getFirstMidName();
			student.setUsername(username);

			String password = "S" + value(sService.findMaxStudentId() + 1) + student.getFirstMidName();
			student.setPassword(password);

			sService.createStudent(student);
			mav.setViewName("redirect:/admin/student/list");

			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		} else {
			message = "Please enter Valid Name (A-Z , a-z) .";
			return mav;
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView studentListPage(HttpSession session) {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		ModelAndView mav = new ModelAndView("AdminStudentList");
		List<Student> studentList = sService.findAllStudents();
		mav.addObject("studentList", studentList);
		return mav;
		
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView studentListPage(HttpServletRequest request) 
	{
		
		String searchDetail = request.getParameter("sname");
		ArrayList<Student> studentList = sService.findStudentByFullName(searchDetail);
		String message = studentList.size() + " search result(s) for \""+ searchDetail + "\"";
		
		ModelAndView mav = new ModelAndView("AdminStudentList");
		mav.addObject("studentList", studentList);
		mav.addObject("message", message);
		return mav;
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable int id, HttpSession session) {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		ModelAndView mav = new ModelAndView("AdminEditStudent");
		Student student = sService.findStudentByStudentID(id);
		mav.addObject("student", student);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Student student, BindingResult result, @PathVariable int id,
			final RedirectAttributes redirectAttributes) /* throws DepartmentNotFound */ {

		String message = "";
		CharSequence nums = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9";

		if (result.hasErrors())
			return new ModelAndView("AdminEditStudent");

		if (!(student.getFirstMidName().contains(nums) && student.getLastName().contains(nums))) {

			ModelAndView mav = new ModelAndView("redirect:/admin/student/list");
			String username = "S" + value(id) + student.getFirstMidName();

			student.setUsername(username);

			String password = "S" + value(id) + student.getFirstMidName();
			student.setPassword(password);
			message = "Student was successfully updated.";

			sService.updateStudent(student);

			redirectAttributes.addFlashAttribute("message", message);
			return mav;

		}

		else {
			message = "Please enter Valid Name (A-Z , a-z) .";
			return new ModelAndView();
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable int id, final RedirectAttributes redirectAttributes,
			HttpSession session)/* throws DepartmentNotFound */ {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		ModelAndView mav = new ModelAndView("redirect:/admin/student/list");
		Student student = sService.findStudentByStudentID(id);
		sService.removeStudent(student);
		String message = "The student " + student.getStudentId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	private String value(int id) {
		return String.format("%03d", id);
	}
}