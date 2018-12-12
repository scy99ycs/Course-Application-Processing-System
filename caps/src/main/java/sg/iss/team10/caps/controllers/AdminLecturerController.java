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

//import edu.iss.cats.exception.EmployeeNotFound;
import sg.iss.team10.caps.model.Admin;
import sg.iss.team10.caps.model.Lecturer;
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
	
	/*@Autowired
	private validator...*/
	
	/*@InitBinder("admin")
	private void initEmployeeBinder(WebDataBinder binder) {
		binder.addValidators(eValidator);*/
	
	/**
	 * ADMIN CRUD OPERATIONS
	 * 
	 * @return
	 */
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newLecturerPage() {
		ModelAndView mav = new ModelAndView("AdminLecturerAdd", "Lecturer", new Lecturer());
		return mav;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView newLecturerPage(@ModelAttribute Lecturer lecturer) {
		ModelAndView mav = new ModelAndView("AdminLecturerAdd", "Lecturer", new Lecturer());
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView lecturerListPage() {
		ArrayList<Lecturer> findAll = lService.findAllLecturers();
		ModelAndView mav = new ModelAndView("AdminLecturerList");
		mav.addObject("lecturerList",findAll);
		return mav;
	}
	
/*
	@RequestMapping(value = "/edit{id}", method = RequestMethod.GET)
	public ModelAndView editLecturerPage(@PathVariable Integer id) {
		Lecturer lecturer = lService.findLecturerById(id);
		ModelAndView mav = new ModelAndView("AdminLecturerEdit","lecturer",Lecturer);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editLecturer(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
			@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws LecturerNotFound {

		if (result.hasErrors())
			return new ModelAndView("lecturer-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/lecturer/list");
		String message = "Lecturer was successfully updated.";

		lService.updateLecturer(lecturer);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteLecturer(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws LecturerNotFound {

		ModelAndView mav = new ModelAndView("redirect:/admin/lecturer/list");
		Lecturer lecturer = lService. findLecturerById(id);
		lService.removeLecturer(lecturer);
		String message = "The lecturer " + lecturer.getStaffId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
*/
}
