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

//import edu.iss.cats.exception.EmployeeNotFound;
import sg.iss.team10.caps.model.Admin;
import sg.iss.team10.caps.model.Lecturer;
import sg.iss.team10.caps.model.Student;
import sg.iss.team10.caps.services.AdminService;
import sg.iss.team10.caps.services.LecturerService;
//import edu.iss.cats.validator.EmployeeValidator;

@RequestMapping("/admin/lecturer")
@Controller
public class AdminLecturerController {
	@Autowired
	private AdminService aService;
	@Autowired
	private LecturerService lService;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newLecturerPage(HttpSession session) {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		ModelAndView mav = new ModelAndView("AdminLecturerAdd", "Lecturer", new Lecturer());
		return mav;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView newLecturerPage(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("AdminLecturerAdd");

		ModelAndView mav = new ModelAndView();
		String message = "New lecturer " + lecturer.getStaffId() + " was successfully added.";

		lService.createLecturer(lecturer);
		mav.setViewName("redirect:/admin/lecturer/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView lecturerListPage(HttpSession session) {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		ArrayList<Lecturer> findAll = lService.findAllLecturers();
		ModelAndView mav = new ModelAndView("AdminLecturerList");
		mav.addObject("lecturerList", findAll);
		return mav;
	}

	@RequestMapping(value = "/edit/{staffid}", method = RequestMethod.GET)
	public ModelAndView editLecturerPage(@PathVariable("staffid") int staffid, HttpSession session) {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		Lecturer lecturer = lService.findLecturerById(staffid);
		ModelAndView mav = new ModelAndView("AdminLecturerEdit");
		mav.addObject("lecturer", lecturer);
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editLecturerPage(@Valid @ModelAttribute("lecturer") Lecturer lecturer, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		String message;

		if (result.hasErrors()) {
			message = "Unsuccessful update";
		} else {
			lService.updateLecturer(lecturer);
			message = "Lecturer was successfully updated.";
		}
		ModelAndView mav = new ModelAndView("redirect:/admin/lecturer/list");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	/*
	 * ModelAndView mav = new ModelAndView("redirect:/admin/lecturer/list");
	 * redirectAttributes.addFlashAttribute("message", message); return mav; }
	 */

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteLecturer(@PathVariable int id, final RedirectAttributes redirectAttributes,
			HttpSession session) {
		if (((UserSession) session.getAttribute("USERSESSION")) == null
				|| ((UserSession) session.getAttribute("USERSESSION")).getAdmin() == null) {
			return new ModelAndView("redirect:/adminlogin");
		}

		ModelAndView mav = new ModelAndView("redirect:/admin/lecturer/list");
		Lecturer lecturer = lService.findLecturerById(id);
		lService.removeLecturer(lecturer);
		String message = "The lecturer " + lecturer.getStaffId() + " was successfully deleted.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}
