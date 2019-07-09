package database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import model.Booking;
import model.Class;
import model.Location;

@Repository
public class BookingDAOHib implements BookingDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void createBooking(Booking booking) {
		Session session = sessionFactory.getCurrentSession();
		session.save(booking);
	}

	@Override
	public void updateBooking(Booking booking) {
		Session session = sessionFactory.getCurrentSession();
		session.update(booking);
	}

	@Override
	public void deleteBooking(Long id) {
		Booking booking = (Booking) sessionFactory.getCurrentSession().load(Booking.class, id);
		sessionFactory.getCurrentSession().delete(booking);	
	}

	@Override
	public List<Location> getAllLocations() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Location.class);
		@SuppressWarnings("unchecked")
		List<Location> locations = criteria.list();
		return locations;
		
	}

	@Override
	public List<Class> getAllClassesByLocation(Long id) {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(Class.class);
		@SuppressWarnings("unchecked")
		List<Class> classesByLocation = (List<Class>) createCriteria.add(Restrictions.eq("location.id", id)).list();
		return classesByLocation;
	}

	@Override
	public Class getClassById(Long id) {
		return (Class) sessionFactory.getCurrentSession().load(Class.class, id);
	}

	@Override
	public Booking getBookingById(Long id) {
		return (Booking) sessionFactory.getCurrentSession().load(Booking.class, id);
	}
	
	

}
