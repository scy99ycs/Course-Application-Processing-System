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

import sg.iss.team10.caps.model.Course;
import sg.iss.team10.caps.services.CourseService;

@RequestMapping(value="/admin/course")
@Controller
public class AdminCourseController 
{
@Autowired
private CourseService courseService;

@RequestMapping(value="/add" ,method=RequestMethod.GET)
public ModelAndView newAddCoursePage()
{
	ModelAndView mav=new ModelAndView("course-new","course", new Course());
	return mav;
}
@RequestMapping(value = "/add", method = RequestMethod.POST)
public ModelAndView addNewCourse(@ModelAttribute @Valid Course course, BindingResult result,
		final RedirectAttributes redirectAttributes){
				if (result.hasErrors()) 
					return new ModelAndView("course-new");
					
			ModelAndView mav = new ModelAndView();
			String message = "New course " + course.getCourseName() + " was successfully created.";
			courseService.createCourse(course);
			mav.setViewName("redirect:/admin/course/list");
			redirectAttributes.addFlashAttribute("message", message);
			return mav;
}

@RequestMapping(value="/list",method=RequestMethod.GET)
public ModelAndView viewAllCourse()
{
	ModelAndView mav=new ModelAndView("AdminCourseList");
	List<Course> courseList=courseService.findAllCourse();
	mav.addObject("courseList",courseList);
	return mav;
}

@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
public ModelAndView editCoursePage(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("course-edit");
	Course course = courseService.findCourseById(id);
	mav.addObject("course", course);
	return mav;
}

@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
public ModelAndView editCourse(@ModelAttribute @Valid Course course, BindingResult result,
		@PathVariable String id, final RedirectAttributes redirectAttributes) 
{

	if (result.hasErrors())
		return new ModelAndView("course-edit");

	ModelAndView mav = new ModelAndView("redirect:/admin/course/list");
	String message = "Course was successfully updated.";

	courseService.changeCourse(course);

	redirectAttributes.addFlashAttribute("message", message);
	return mav;
}

@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public ModelAndView deleteDepartment(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
	 {

	ModelAndView mav = new ModelAndView("redirect:/admin/course/list");
	Course course = courseService.findCourseById(id);
	courseService.removeCourse(course);
	String message = "The course " + course.getCourseId() + " was successfully deleted.";

	redirectAttributes.addFlashAttribute("message", message);
	return mav;
}


}