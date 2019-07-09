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
import model.Booking;
import model.Person;
import services.BookingService;
import services.UserService;

/**
 * @author fabianwoodman
 *
 */
@Controller
@RequestMapping("/")
@Transactional
public class ManageBookingController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	UserDAO userDAO;
	
	Person customer = new Person();
	@RequestMapping("/classes/manage")
	public ModelAndView ModelAndView(Principal principal) 
	{
		
		customer = userService.retrieveUserByEmail(principal.getName());
		
		ModelAndView model = new ModelAndView("yogawebapp/ManageBookings");
		model.setViewName("yogawebapp/ManageBookings");
		model.addObject("FirstName", customer.getForenames());
		model.addObject("SecondName", customer.getSurname());
		
		List<Booking> currentBookings = userService.getBookingByUserId(customer.getId());
		model.addObject("userBookings", currentBookings);
	
		return model;
	}
	
	@RequestMapping(value="/classes/cancel", method = RequestMethod.POST)
	public ModelAndView cancelClasses (@RequestParam("booking_id")Long booking_id, Principal principal) 
	{
		ModelAndView model = new ModelAndView("yogawebapp/ManageBookings");
		model.setViewName("yogawebapp/ManageBookings");
		
		//gets booking that is to be updated as cancelled by the user
		Booking currentBooking = bookingService.retrieveBookingById(booking_id);
		//cancels Bookings and updates in using service method
		currentBooking.setIsCancelled(true);
		bookingService.updateBooking(currentBooking);
		
		System.out.println("booking id : " + booking_id + " should be cancelled!");
		
		//updates list of bookings
		List<Booking> currentBookings = userService.getBookingByUserId(customer.getId());
		model.addObject("userBookings", currentBookings);
	
		return ModelAndView(principal);
	}

}
