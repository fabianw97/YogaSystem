/**
 * 
 */
package web;

import java.security.Principal;
import java.sql.Date;
import java.sql.Time;
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
import model.Location;
import model.Class;
import model.ClassType;
import services.BookingService;
import services.ClassService;
import services.LocationService;
import services.UserService;

/**
 * @author fabianwoodman
 *
 */
@Controller
@RequestMapping("/")
@Transactional
public class AddNewClassController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private ClassService classService;

	@Autowired
	UserDAO userDAO;

	@RequestMapping("/classes/createClass")
	public ModelAndView ModelAndView(Principal principal) {
		Person customer = new Person();
		customer = userService.retrieveUserByEmail(principal.getName());

		ModelAndView model = new ModelAndView("yogawebapp/AddNewClass");
		model.addObject("FirstName", customer.getForenames());
		model.addObject("LastName", customer.getSurname());

		List<Location> locations = bookingService.getAllLocations();
		List<ClassType> classTypes = classService.getAllClassTypes();
		List<Tutor> tutors = userService.getAllTutors();

		model.addObject("locations", locations);
		model.addObject("classTypes", classTypes);
		model.addObject("tutors", tutors);

		return model;
	}

	@RequestMapping(value = "/classes/createClass/submitClass", method = RequestMethod.POST)
	public ModelAndView submitClass(@RequestParam("location_id") Long locationId,
			@RequestParam("class_type_id") Long classTypeId, @RequestParam("dateStart") Date dateStart,
			@RequestParam("dateEnd") Date dateEnd, @RequestParam("timeStart") String timeStart,
			@RequestParam("duration") int duration, @RequestParam("dayOfWeek") int dayOfWeek,
			@RequestParam("tutor_id") Long tutorId, Principal principal) {
		//ModelAndView model = new ModelAndView("yogawebapp/addNewClass");

		try {
			Class newClass = new Class();
			// Instantiate new location and classType objects for foreign keys
			// in the Class object
			Location location = new Location();
			ClassType classType = new ClassType();

			location = locationService.getLocationById(locationId);
			classType = classService.getClassTypeById(classTypeId);

			String tS = timeStart + ":00";

			newClass.setLocation(location);
			newClass.setClass_type(classType);
			newClass.setDate_start(dateStart);
			newClass.setDateEnd(dateEnd);
			newClass.setTimeStart(Time.valueOf(tS));
			newClass.setDuration(duration);
			newClass.setDayOfWeek(dayOfWeek);
			newClass.setCancelAll(false);

			// TODO Problems trying to implement multiple tutors for one class
			/**
			 * for(int t : tutorId){ TutorClass[] tutorClass = new
			 * TutorClass[t]; Tutor tutor = new Tutor(); tutor =
			 * userService.getTutorById(Integer.toUnsignedLong(t));
			 * tutorClass[t].setTutor(tutor); tutorClass[t].set_class(newClass);
			 * classService.createTutorClass(tutorClass); }
			 **/

			TutorClass tutorClass = new TutorClass();
			Tutor tutor = new Tutor();
			tutor = userService.getTutorById(tutorId);
			tutorClass.setTutor(tutor);
			tutorClass.set_class(newClass);

			classService.createClass(newClass, tutorClass);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ModelAndView(principal);

	}
}
