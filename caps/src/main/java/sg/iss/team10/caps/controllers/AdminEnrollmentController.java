package sg.iss.team10.caps.controllers;

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

import sg.iss.team10.caps.model.Enrollment;
import sg.iss.team10.caps.services.CourseService;
import sg.iss.team10.caps.services.EnrollmentService;
import sg.iss.team10.caps.services.StudentService;
import sg.iss.team10.caps.validator.AdminEnrollmentValidator;

@RequestMapping(value="/admin/enrollment")
@Controller
public class AdminEnrollmentController {
	
	@Autowired
	private EnrollmentService eService;
	@Autowired
	private StudentService sService;
	@Autowired
	private CourseService cService;
	
	@Autowired
	private AdminEnrollmentValidator aValidator;
	
	@InitBinder("enrollment")
	private void initStudentBinder(WebDataBinder binder)
	{
		binder.addValidators(aValidator);
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView newAddEnrollmentPage()
	{
		ModelAndView mav= new ModelAndView("AdminAddEnrollment","enrollment",new Enrollment());
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createNewEnrollment(@ModelAttribute @Valid Enrollment enrollment, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		
		String message="";
		
		if (result.hasErrors())
			return new ModelAndView("AdminAddEnrollment");
		
		if(sService.findStudentByStudentID(enrollment.getStudentId())!=null && cService.findCourseById(enrollment.getCourseId())!=null) {
			ModelAndView mav = new ModelAndView();
			message = "New Enrollment " + enrollment.getEnrollmentId() + " was successfully created.";
	
			eService.createEnrollment(enrollment);
			mav.setViewName("redirect:/admin/enrollment/list");
	
			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}
		else {
			message = "Please enter Valid Data .";
			return new ModelAndView();
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView enrollmentListPage() {
		ModelAndView mav = new ModelAndView("AdminEnrollmentList");
		List<Enrollment> enrollmentList = eService.findAllEnrollment();
		mav.addObject("enrollmentList", enrollmentList);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEnrollmentPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("AdminEditEnrollment");
		Enrollment enrollment = eService.findEnrollmentById(id);
		int stuid= id;
		mav.addObject("stuid", stuid);
		mav.addObject("enrollment", enrollment);
		//mav.addObject("sidlist", sService.findAllStudentsId());
		//mav.addObject("sidlist", cService.findAllCourseIds());
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editEnrollment(@ModelAttribute @Valid Enrollment enrollment, BindingResult result,
			@PathVariable int id, final RedirectAttributes redirectAttributes) /*throws DepartmentNotFound*/ {

		String message="";
		
		if (result.hasErrors())
			return new ModelAndView("AdminEditEnrollment");
		if(sService.findStudentByStudentID(enrollment.getStudentId())!=null && cService.findCourseById(enrollment.getCourseId())!=null) {
			ModelAndView mav = new ModelAndView("redirect:/admin/enrollment/list");
			message = "Enrollment was successfully updated.";
	
			eService.updateEnrollment(enrollment);
	
			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}
		else {
			message = "Please enter Valid Data .";
			return new ModelAndView();
		}
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

/*<td><form:select path="studentId" items="${sidList}"/></td>
 * <td><form:select path="studentId" items="${sidList}"/></td>*/