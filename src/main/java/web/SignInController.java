/**
 * 
 */
package web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
public class SignInController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/signInRequest", method = RequestMethod.POST)
	public ModelAndView SignInRequest(@RequestParam("user_email") String email,
			@RequestParam("user_password") String password, HttpSession session, Principal principal) {
		Person user;
		ModelAndView modelAndView = new ModelAndView("yogawebapp/index");

		try {
			user = userService.retrieveUserByEmail(email);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
			return modelAndView;
		}

		try {
			if (!user.getEmail().equals(null)) {
				if (user.getEmail().equals(email) && user.getPassword().equals(password)) {

					System.out.println(user.getEmail() + " " + user.getPassword());
					Person customer = new Person();
					customer = userService.retrieveUserByEmail(principal.getName());

					// TODO Home page needs to be created
					ModelAndView modelSuccess = new ModelAndView("yogawebapp/Home");
					modelSuccess.setViewName("yogawebapp/Home");
					session.setAttribute("UserObj", customer);
					modelSuccess.addObject("FirstName", customer.getForenames());
					modelSuccess.addObject("LastName", customer.getSurname());

					List<Booking> currentBookings = userService.getBookingByUserId(user.getId());

					modelSuccess.addObject("userBookings", currentBookings);

					// should return homepage if successful
					System.out.println("Log in success");
					return modelSuccess;
				}
			} else {
				System.out.println("Login error");
				//modelAndView.setViewName("Login error");
				modelAndView.addObject("error","Incorrect Email or Password");
				return modelAndView;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Login error");
		}
		return modelAndView;
	}
}
