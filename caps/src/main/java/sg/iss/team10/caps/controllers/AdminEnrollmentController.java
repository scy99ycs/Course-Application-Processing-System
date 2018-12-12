package sg.iss.team10.caps.controllers;

import java.util.ArrayList;
import java.util.List;

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

import sg.iss.team10.caps.model.Enrollment;
import sg.iss.team10.caps.model.Student;
import sg.iss.team10.caps.services.EnrollmentService;
import sg.iss.team10.caps.services.StudentService;

@RequestMapping(value="/admin/enrollment")
@Controller
public class AdminEnrollmentController {
	
	@Autowired
	private EnrollmentService eService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView newAddEnrollmentPage()
	{
		ModelAndView mav= new ModelAndView("enrollment-new","enrollment",new Enrollment());
		mav.addObject("eidlist", eService.findAllEnrollment());
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createNewEnrollment(@ModelAttribute @Valid Enrollment enrollment, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("enrollment-new");

		ModelAndView mav = new ModelAndView();
		String message = "New Enrollment " + enrollment.getEnrollmentId() + " was successfully created.";

		eService.createEnrollment(enrollment);
		mav.setViewName("redirect:/admin/enrollment/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView enrollmentListPage() {
		ModelAndView mav = new ModelAndView("enrollment-list");
		List<Enrollment> enrollmentList = eService.findAllEnrollment();
		mav.addObject("enrollmentList", enrollmentList);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEnrollmentPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("enrollment-edit");
		ArrayList<Enrollment> enrollment = eService.findEnrollmentByStudentID(id);
		mav.addObject("enrollment", enrollment);
		mav.addObject("sidlist", eService.findAllEnrollment());
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editEnrollment(@ModelAttribute @Valid Enrollment enrollment, BindingResult result,
			@PathVariable int id, final RedirectAttributes redirectAttributes) /*throws DepartmentNotFound*/ {

		if (result.hasErrors())
			return new ModelAndView("enrollment-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/enrollment/list");
		String message = "Enrollment was successfully updated.";

		eService.updateEnrollment(enrollment);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
		
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEnrollment(@PathVariable int id, final RedirectAttributes redirectAttributes)
			/*throws DepartmentNotFound*/ {

		ModelAndView mav = new ModelAndView("redirect:/admin/enrollment/list");
		Enrollment enrollment = eService.searchEnrollmentByEnrollmentId(id);
		eService.removeEnrollment(enrollment);
		String message = "The enrollment " + enrollment.getEnrollmentId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}

