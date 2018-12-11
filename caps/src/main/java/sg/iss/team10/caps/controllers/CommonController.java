package sg.iss.team10.caps.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team10.caps.model.Admin;
import sg.iss.team10.caps.services.AdminService;

@Controller
//@RequestMapping(value = "/home")
public class CommonController {

	@Autowired
	private AdminService aService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("Home");
	}

	// need to think how to link from home page to relevant login page
//	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
//	public String adminLogin(Model model) {
//		model.addAttribute("admin", new Admin());
//		return "AdminLogin";
//	}
	
	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public ModelAndView adminLogin() {
		ModelAndView mav = new ModelAndView("AdminLogin");
		//model.addAttribute("admin", new Admin());
		return mav;
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ModelAndView adminAuthenticate(@ModelAttribute Admin admin, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("AdminLogin");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		if (admin.getUsername() != null && admin.getPassword() != null) {
			Admin ad = aService.authenticate(admin.getUsername(), admin.getPassword());
			if (ad == null) {
				return mav;
			} else {
				us.setSessionId(session.getId());
				us.setAdmin(ad);
				mav = new ModelAndView("redirect:/admin/landing");
			}
		} else {
			return mav;
		}
		session.setAttribute("ADMINSESSION", us);
		return mav;
	}
}
