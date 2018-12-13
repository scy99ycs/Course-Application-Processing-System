package sg.iss.team10.caps.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

@RequestMapping(value="/admin/student")
@Controller
public class AdminStudentController {
	
	@Autowired
	private StudentService sService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView newAddStudentPage()
	{
		ModelAndView mav= new ModelAndView("AdminAddStudent","student",new Student());
		int length =sService.findAllStudents().size() + 1;
		mav.addObject("sid",length );
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@ModelAttribute @Valid Student student, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("AdminAddStudent");

		ModelAndView mav = new ModelAndView();
		String message = "New Student " + student.getStudentId() + " was successfully created.";
		
		String username ="S"+value(student.getStudentId())+student.getFirstMidName();
		
		student.setUsername(username);
		
		String password ="S"+value(student.getStudentId())+student.getFirstMidName();
		student.setPassword(password);
		
		
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//give format in which you are receiving the `String date_updated`
	    //Date date = sdf.parse(student.getEnrollmentDate());
	    //java.sql.Date sqlDate_updated = new java.sql.Date(date.getTime());
		
		
		
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
		ModelAndView mav = new ModelAndView("AdminEditStudent");
		Student student = sService.findStudentByStudentID(id);
		mav.addObject("student", student);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Student student, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes) /*throws DepartmentNotFound*/ {

		if (result.hasErrors())
			return new ModelAndView("AdminEditStudent");

		ModelAndView mav = new ModelAndView("redirect:/admin/student/list");
		String username ="S"+value(student.getStudentId())+student.getFirstMidName();
		
		student.setUsername(username);
		
		String password ="S"+value(student.getStudentId())+student.getFirstMidName();
		student.setPassword(password);
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
	
	private String value(int id)
	{
		return String.format("%03d", id);
	}
}