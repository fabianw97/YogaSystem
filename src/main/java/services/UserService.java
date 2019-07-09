/**
 * 
 */
package services;

import java.util.List;

import model.Booking;
import model.Person;
import model.Tutor;
import security.UserAuthority;

/**
 * @author fabianwoodman
 *
 */
public interface UserService {
	
	public Person retrieveUser(Long id);
	
	public void updateUser(Person user);
	
	public Person retrieveUserByEmail(String email);

	public void createNewUser(Person user, UserAuthority userAuthority);
	
	public Boolean userPresent(String email);
	
	public List<Booking> getBookingByUserId(Long id);
	
	public List<Tutor> getAllTutors();
	
	public List<Person> getAllUsers();
	
	//public List<Person> getAllCustomers();
	
	public Tutor getTutorById(Long id);
	

}
