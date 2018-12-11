package sg.iss.team10.caps.controllers;

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import sg.iss.team10.caps.model.Course;
//import sg.iss.team10.caps.model.Enrollment;
//import sg.iss.team10.caps.services.CourseService;
//import sg.iss.team10.caps.services.EnrollmentService;
//
//@Controller
//public class StudentController {
//
//	@RequestMapping("/Student")
//	public String showpage() {
//		return "StudentController";
		
//	}
//	
//	
//	@Autowired
//	private EnrollmentService eService;
//	@Autowired
//	private CourseService cService;
//	
//	@GetMapping
// 	@RequestMapping(value = "/list")
//	public ModelAndView EnrollmentListPage() {
//		ModelAndView mav = new ModelAndView("department-list");
//		List<Enrollment> departmentList = eService.findAllEnrollment();
//		mav.addObject("departmentList", departmentList);
//		return mav;
//	}
//	
//	@PostMapping("/search")
//    public String searchCourseByCourseName(@RequestParam("CourseName") String courseName,
//                                    Model Course) {
////
////        // search customers from the service
////        List<Course>  = CourseService.findCourseByCourseName(courseName);
////                
////        // add the customers to the model
////        Course.addAttribute("Course", course);
////
////        return "list-customers";        
//    }
	


