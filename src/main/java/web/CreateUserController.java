/**
 * 
 */
package web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Person;
import model.Tutor;
import security.UserAuthority;
import services.TutorService;
import services.UserService;

/**
 * @author fabianwoodman
 *
 */
@Controller
@RequestMapping("/")
@Transactional
public class CreateUserController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("tutorServiceImpl")
	private TutorService tutorService;

	@RequestMapping("/createUser")
	public ModelAndView ModelAndView(Principal principal) {
		ModelAndView model = new ModelAndView("yogawebapp/CreateUser");
		
		Person user = new Person();
		user = userService.retrieveUserByEmail(principal.getName());
		
		model.addObject("FirstName", user.getForenames());
		model.addObject("LastName", user.getSurname());
		
		return model;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addNewUser(@RequestParam("user_fname") String fName, @RequestParam("user_lname") String lName,
			@RequestParam("user_phonenum") String phoneNum, @RequestParam("user_email") String email,
			@RequestParam("user_password") String password, @RequestParam("user_type")String uac, Principal principal) {

		ModelAndView model = new ModelAndView("yogawebapp/CreateUser");

		try {
			if (!userService.userPresent(email).equals(true)) {
				if (email!=null) {
					Person newUser = new Person();
					UserAuthority newUserAuthority = new UserAuthority(); 
					Tutor newTutor = new Tutor();
					
					newUser.setForenames(fName);
					newUser.setSurname(lName);
					newUser.setPhoneNum(phoneNum);
					newUser.setEmail(email);
					newUser.setPassword(password);
					newUser.setUac(uac);
					
					newUserAuthority.setAuthority(uac);
					newUserAuthority.setUserLog(newUser);
					
					newTutor.setPerson(newUser);	
					

					try {
						userService.createNewUser(newUser,newUserAuthority);
						tutorService.createTutor(newTutor);	
						
						ModelAndView modelSuccess = new ModelAndView("yogawebapp/CreateUser");
						System.out.print(newUser);
						System.out.print("User created!!");
						
						modelSuccess.addObject("message", "You have successfully created a new user");
						modelSuccess.setViewName("yogawebapp/CreateUser");
						
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
