/**
 * 
 */
package web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import database.UserDAO;
import model.Person;
import model.ClassType;
import services.ClassService;
import services.UserService;

/**
 * @author fabianwoodman
 *
 */
@Controller
@RequestMapping("/")
@Transactional
public class AddClassTypeController {

	@Autowired
	private UserService userService;

	@Autowired
	private ClassService classService;

	@Autowired
	UserDAO userDAO;

	@RequestMapping("/classes/createClassType")
	public ModelAndView ModelAndView(Principal principal) {
		Person customer = new Person();
		customer = userService.retrieveUserByEmail(principal.getName());

		ModelAndView model = new ModelAndView("yogawebapp/AddClassType");
		model.addObject("FirstName", customer.getForenames());
		model.addObject("LastName", customer.getSurname());

		return model;
	}

	@RequestMapping(value = "/classes/createClassType/submitType", method = RequestMethod.POST)
	public ModelAndView submitClass(@RequestParam("className") String className,
			@RequestParam("classDescription") String classDescription, Principal principal) {
		ModelAndView model = new ModelAndView("yogawebapp/AddClassType");

		try {
			ClassType classType = new ClassType();
			
			classType.setClassName(className);
			classType.setClassDescription(classDescription);
			
			classService.createClassType(classType);
			
			model.addObject("success", "Class Type Successfully added!");
			
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			model.addObject("success", "Error please try again");
		}

		return model;

	}
}
