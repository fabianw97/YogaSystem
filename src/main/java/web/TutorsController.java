/**
 * 
 */
package web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import database.UserDAO;
import model.Person;
import model.Tutor;
import model.TutorClass;
import services.TutorService;
import services.UserService;

/**
 * @author fabianwoodman
 *
 */
@Controller
@RequestMapping("/")
@Transactional
public class TutorsController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TutorService tutorService;
	
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value="/tutors", method = RequestMethod.GET)
	public ModelAndView ModelAndView(@RequestParam(value="tutor_id", required = false)Long id,Principal principal) 
	{
		Person customer = new Person();
		customer = userService.retrieveUserByEmail(principal.getName());
		
		ModelAndView model = new ModelAndView("yogawebapp/Tutors");
		model.addObject("FirstName", customer.getForenames());
		model.addObject("LastName", customer.getSurname());
		 
		List<Tutor> tutors = userService.getAllTutors();
		model.addObject("tutors",tutors);
		
		List<TutorClass> tutorsClasses = tutorService.getTutorClasses(id);
		model.addObject("tutorClasses", tutorsClasses);
		
		return model;
	}

}
