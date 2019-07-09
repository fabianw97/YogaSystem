package web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import services.UserService;

@Controller
public class SignOutController {
	@Autowired
	UserService userService;

	@RequestMapping("/logout")
	protected ModelAndView doPost(HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView("yogawebapp/index");
		modelAndView.setViewName("yogawebapp/index");
		System.out.println(session.getAttribute("UserObj").toString() + " successfully logged out!");
		session.removeAttribute("UserObj");
		
		return modelAndView;
	}
}
