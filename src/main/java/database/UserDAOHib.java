/**
 * 
 */
package database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import model.Booking;
import model.Person;
import model.Tutor;
import security.User;
import security.UserAuthority;
import security.UserUtils;

/**
 * @author fabianwoodman
 *
 */
@Repository(value = "userDAOHib")
public class UserDAOHib implements UserDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public Person retrieveUser(Long id) {
		// TODO Auto-generated method stub
		return (Person) sessionFactory.getCurrentSession().load(Person.class, id);
	}

	@Override
	public void createUser(Person user, UserAuthority userAuthority) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		session.save(userAuthority);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		Person user = (Person) sessionFactory.getCurrentSession().load(Person.class, id);
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public void updateUser(Person user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		//session.flush();
	}

	@Override
	public Person findUser(Person user) {
		// TODO Auto-generated method stub

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(user.getClass());
		Person userFound = (Person) criteria.add(Example.create(user)).list().get(0);
		return userFound;
	}

	@Override
	public Boolean userPresent(String email) {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(Person.class);
		Person possibleUser = (Person) createCriteria.add(Restrictions.eq("email", email)).uniqueResult();
		boolean notPresent;
		if (!(possibleUser == null)){
			notPresent = true;
		}
		else{
			notPresent = false;
		}
		return notPresent;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getBookingByUserId(Long id) {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(Booking.class);
		createCriteria.addOrder(Order.asc("dateStart"));
		createCriteria.addOrder(Order.asc("timeStart"));
		createCriteria.addOrder(Order.asc("id"));
		List<Booking> retrievedBooking = (List<Booking>) createCriteria.add(Restrictions.eq("person.id", id)).list();
		retrievedBooking = (List<Booking>) createCriteria.add(Restrictions.eq("isCancelled", false)).list();
		return retrievedBooking;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public User getLoggedInUser() {
		UserUtils user = new UserUtils();
		return user.getLoggedInUser();
	}

	@Override
	public List<Tutor> getAllTutors() {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(Tutor.class);
		@SuppressWarnings("unchecked")
		List<Tutor> tutors = (List<Tutor>) createCriteria.list();
		return tutors;
	}

	@Override
	public List<Person> getAllUsers() {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(Person.class);
		@SuppressWarnings("unchecked")
		List<Person> users = (List<Person>) createCriteria.list();
		return users;
	}

	@Override
	public Tutor retrieveTutorById(Long id) {
		return (Tutor) sessionFactory.getCurrentSession().load(Tutor.class, id);
	}
	
	/**
	@Override
	public List<Person> getAllCustomers() {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(Person.class);
		@SuppressWarnings("unchecked")
		List<Person> allCustomers = (List<Person>) createCriteria.add(Restrictions.eq("authorities.authority", "Customer")).list();
		return allCustomers;
	}
	
	**/

}
