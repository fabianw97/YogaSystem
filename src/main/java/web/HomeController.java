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
import org.springframework.web.servlet.ModelAndView;

import database.UserDAO;
import model.Booking;
import model.Person;
import services.UserService;

/**
 * @author fabianwoodman
 *
 */
@Controller
@RequestMapping("/")
@Transactional
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	UserDAO userDAO;

	@RequestMapping("/home**")
	public ModelAndView ModelAndView(Principal principal) 
	{
		Person customer = new Person();
		customer = userService.retrieveUserByEmail(principal.getName());
		
		ModelAndView model = new ModelAndView("yogawebapp/Home");
		model.setViewName("yogawebapp/Home");
		model.addObject("FirstName", customer.getForenames());
		model.addObject("LastName", customer.getSurname());
		List<Booking> currentBookings = userService.getBookingByUserId(customer.getId());
		
		model.addObject("userBookings", currentBookings);
		
		return model;
	}

}
