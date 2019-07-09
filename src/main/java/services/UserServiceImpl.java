package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.UserDAOHib;
import model.Booking;
import model.Person;
import model.Tutor;
import security.UserAuthority;

/**
 * @author fabianwoodman
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("userDAOHib")
	private UserDAOHib userDAO;
	
	@Override
	public Person retrieveUser(Long id) {
		Person user = userDAO.retrieveUser(id);
		return user;
	}

	@Override
	public void updateUser(Person user) {
		userDAO.updateUser(user);
		
	}

	@Override
	public Person retrieveUserByEmail(String email) {
		Person user = new Person();
		user.setEmail(email);
		return userDAO.findUser(user);
	}
	
	@Override 
	public void createNewUser(Person user, UserAuthority userAuthority){
		userDAO.createUser(user,userAuthority);
	}

	@Override
	public Boolean userPresent(String email) {
		return userDAO.userPresent(email);
	}

	@Override
	public List<Booking> getBookingByUserId(Long id) {
		// TODO Auto-generated method stub
		List<Booking> booking = userDAO.getBookingByUserId(id);
		
		return booking;
	}

	@Override
	public List<Tutor> getAllTutors() {
		List<Tutor> tutors = userDAO.getAllTutors();
		return tutors;
	}

	@Override
	public List<Person> getAllUsers() {
		List<Person> users = userDAO.getAllUsers();
		return users;
	}

	@Override
	public Tutor getTutorById(Long id) {
		Tutor tutor = userDAO.retrieveTutorById(id);
		return tutor;
	}
	
	/**
	@Override
	public List<Person> getAllCustomers() {
		List<Person> customers = userDAO.getAllCustomers();
		return customers;
	}
	
	**/
	
	

}
