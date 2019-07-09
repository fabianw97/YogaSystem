/**
 * 
 */
package web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Person;
import security.UserAuthority;
import services.UserService;

/**
 * @author fabianwoodman
 *
 */
@Controller
@RequestMapping("/")
@Transactional
public class RegisterController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	@RequestMapping("/register")
	public ModelAndView ModelAndView() {
		ModelAndView model = new ModelAndView("yogawebapp/register");
		model.setViewName("yogawebapp/register");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addNewUser(@RequestParam("user_fname") String fName, @RequestParam("user_lname") String lName,
			@RequestParam("user_phonenum") String phoneNum, @RequestParam("user_email") String email,
			@RequestParam("user_password") String password, HttpSession session) {

		ModelAndView model = new ModelAndView("yogawebapp/register");

		try {
			if (!userService.userPresent(email).equals(true)) {
				if (email!=null) {
					Person newUser = new Person();
					UserAuthority newUserAuthority = new UserAuthority(); 
					
					newUser.setForenames(fName);
					newUser.setSurname(lName);
					newUser.setPhoneNum(phoneNum);
					newUser.setEmail(email);
					newUser.setPassword(password);
					newUser.setAuthorities(null);
					newUser.setUac("Customer");
					
					
					
					newUserAuthority.setAuthority("Customer");
					newUserAuthority.setUserLog(newUser);

					try {
						userService.createNewUser(newUser,newUserAuthority);
						ModelAndView modelSuccess = new ModelAndView("yogawebapp/register");
						System.out.print(newUser);
						System.out.print("User created!!");
						
						modelSuccess.addObject("message", "You have successfully Registered!");
						modelSuccess.setViewName("yogawebapp/register");
						
						return modelSuccess;

					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("User email null");
					model.addObject("message", "Enter email and password");
					return model;
				}
			} else {
				model.addObject("message", "Email is already registered on the system");
				//TODO email already used error handling
				return model;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;

	}
}
