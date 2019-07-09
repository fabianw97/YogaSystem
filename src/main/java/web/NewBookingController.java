/**
 * 
 */
package web;

import java.security.Principal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import database.UserDAO;
import model.Booking;
import model.Class;
import model.Person;
import model.Location;
import services.BookingService;
import services.UserService;

/**
 * @author fabianwoodman
 *
 */
@Controller
@RequestMapping("/")
@Transactional
public class NewBookingController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/classes/book", method = RequestMethod.GET)
	public ModelAndView newView(@RequestParam(value = "location_id", required = false) Long locationId,
			Principal principal) {
		Person customer = new Person();
		customer = userService.retrieveUserByEmail(principal.getName());

		ModelAndView model = new ModelAndView("yogawebapp/NewBooking");
		// model.setViewName("yogawebapp/NewBooking");
		model.addObject("FirstName", customer.getForenames());
		model.addObject("SecondName", customer.getSurname());

		List<Location> allLocations = bookingService.getAllLocations();
		model.addObject("locations", allLocations);

		List<Class> allClasses = bookingService.getAllClassByLocation(locationId);
		model.addObject("allClasses", allClasses);
		
		List<Person> allUsers = userService.getAllUsers();
		model.addObject("users", allUsers);

		return model;
	}

	@RequestMapping(value = "/classes/addClass", method = RequestMethod.POST)
	public ModelAndView NewBooking(@RequestParam("class_id") Long classId, @RequestParam("dateStart") Date dateStart,
			@RequestParam("timeStart") String timeStart, @RequestParam("timeEnd") String timeEnd,
			@RequestParam(value = "user_id", required = false) Long userId, Principal principal) {
		ModelAndView model = new ModelAndView("yogawebapp/NewBooking");

		Person customer = new Person();
		Class newClass = new Class();

		try {
			Booking newBooking = new Booking();
			if (userId != null) {
				// Tutor and admin selected
				customer = userService.retrieveUser(userId);
				newBooking.setCustomer(customer);
			} else {
				// Based of currently logged in customer
				customer = userService.retrieveUserByEmail(principal.getName());
				newBooking.setCustomer(customer);
			}
			newClass = bookingService.getClassById(classId);
			System.out.println(newClass.getClass_type().getClassName());
			System.out.println(newClass.getLocation().getId());

			// Making times into correct format to be stored
			// Add getting todays date for DateCreated field
			String tS = timeStart + ":00";
			String tE = timeEnd + ":00";

			LocalDate currentDate = LocalDate.now();

			newBooking.set_class(newClass);
			newBooking.setDateCreated(Date.valueOf(currentDate));
			newBooking.setDateStart(dateStart);
			newBooking.setTimeStart(Time.valueOf(tS));
			newBooking.setTimeEnd(Time.valueOf(tE));
			newBooking.setIsCancelled(false);

			model.addObject("success", "See you at your next class");

			bookingService.createBooking(newBooking);
			System.out.println("New Class successfully Booked!" + newBooking.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return newView(null, principal);
		// return model;
	}

}
