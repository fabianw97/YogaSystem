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
import services.UserService;

/**
 * @author fabianwoodman
 *
 */
@Controller
@RequestMapping("/")
@Transactional
public class EditProfileController {

	@Autowired
	private UserService userService;

	@Autowired
	UserDAO userDAO;

	@RequestMapping("/editProfile")
	public ModelAndView newView(Principal principal) {
		Person customer = new Person();
		customer = userService.retrieveUserByEmail(principal.getName());

		ModelAndView model = new ModelAndView("yogawebapp/EditProfile");
		model.addObject("FirstName", customer.getForenames());
		model.addObject("SecondName", customer.getSurname());
		model.addObject("userEmail", customer.getEmail());
		model.addObject("userPassword", customer.getPassword());
		model.addObject("userPhoneNum", customer.getPhoneNum());

		return model;
	}

	@RequestMapping(value = "/editProfile/submitUpdates", method = RequestMethod.POST)
	public ModelAndView submitChanges(@RequestParam("firstName") String firstName,
			@RequestParam("secondName") String lastName, @RequestParam("phonNum") String phoneNumber,
			Principal principal) {
		ModelAndView model = new ModelAndView("yogawebapp/EditProfile");

		

		try {

			Person updatedCustomer = new Person();
			updatedCustomer = userService.retrieveUserByEmail(principal.getName());
			updatedCustomer.setForenames(firstName);
			updatedCustomer.setSurname(lastName);
			updatedCustomer.setPhoneNum(phoneNumber);

			userService.updateUser(updatedCustomer);
			System.out.println("Successfully updated Customer details");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		
		Person customer = new Person();
		customer = userService.retrieveUserByEmail(principal.getName());
		
		model.addObject("FirstName", customer.getForenames());
		model.addObject("SecondName", customer.getSurname());

		return newView(principal);
	}

}
