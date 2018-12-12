package sg.iss.team10.caps.controllers;

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

import sg.iss.team10.caps.model.Student;
import sg.iss.team10.caps.services.StudentService;

@RequestMapping(value="/admin/student")
@Controller
public class AdminStudentController {
	
	@Autowired
	private StudentService sService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView newAddStudentPage()
	{
		ModelAndView mav= new ModelAndView("student-new","student",new Student());
		mav.addObject("sidlist", sService.findAllStudents());
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@ModelAttribute @Valid Student student, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("student-new");

		ModelAndView mav = new ModelAndView();
		String message = "New Student " + student.getStudentId() + " was successfully created.";

		sService.createStudent(student);
		mav.setViewName("redirect:/admin/student/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView studentListPage() {
		ModelAndView mav = new ModelAndView("AdminStudentList");
		List<Student> studentList = sService.findAllStudents();
		mav.addObject("studentList", studentList);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("student-edit");
		Student student = sService.findStudentByStudentID(id);
		mav.addObject("student", student);
		mav.addObject("sidlist", sService.findAllStudents());
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Student student, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes) /*throws DepartmentNotFound*/ {

		if (result.hasErrors())
			return new ModelAndView("student-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/student/list");
		String message = "Student was successfully updated.";

		sService.updateStudent(student);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
		
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable int id, final RedirectAttributes redirectAttributes)
			/*throws DepartmentNotFound*/ {

		ModelAndView mav = new ModelAndView("redirect:/admin/student/list");
		Student student = sService.findStudentByStudentID(id);
		sService.removeStudent(student);
		String message = "The student " + student.getStudentId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}
