package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Fabian Woodman
 * 
 */
@Controller
public class IndexController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(
			@RequestParam(value = "error", required = false) String error) {

		ModelAndView model = new ModelAndView("yogawebapp/index");

		if (error != null) {
			model.addObject("error", "incorrect username or password");
		}

		model.setViewName("yogawebapp/index");

		return model;
	}
}