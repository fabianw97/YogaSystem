package database;

import java.util.List;

import model.Booking;
import model.Person;
import model.Tutor;
import security.User;
import security.UserAuthority;

/**
 * 
 * @author fabianwoodman
 *
 */

public interface UserDAO {
	
	/**
	 * 
	 * @param id
	 * @return User object
	 * Get a user by id
	 */
	public Person retrieveUser(Long id);
	
	/**
	 * 
	 * @param user
	 * Creates a new user
	 */
	public void createUser(Person user, UserAuthority userAuthority);
	
	/**
	 * 
	 * @param id
	 * Deletes an existing user
	 */
	public void deleteUser(Long id);
	
	/**
	 * 
	 * @param user
	 * Updates an existing users details
	 */
	public void updateUser(Person user);
	
	/**
	 * 
	 * @param user
	 * @return User
	 * Finds any user in the system using their details passed  in
	 */
	public Person findUser(Person user);

	public Boolean userPresent(String email);
	
	/**
	 * 
	 * @param id
	 * @return list of bookings
	 */
	public List<Booking> getBookingByUserId(Long id);

	/**
	 * 
	 * @return User 
	 * Gets the currently logged in user 
	 */
	public User getLoggedInUser();
	
	/**
	 * 
	 * @return list of tutors
	 */
	public List<Tutor> getAllTutors();
	
	
	/**
	 * 
	 * @return list of all users
	 */
	public List<Person> getAllUsers();
	
	/**
	 * 
	 * @return list of people who are customers only
	 */
	//public List<Person> getAllCustomers();
	
	public Tutor retrieveTutorById(Long id);
	
	

}
