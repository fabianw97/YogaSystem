package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.BookingDAOHib;
import model.Booking;
import model.Class;
import model.Location;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	@Qualifier("bookingDAOHib")
	private BookingDAOHib bookingDAO;

	@Override
	public void createBooking(Booking booking) {
		bookingDAO.createBooking(booking);	
	}

	@Override
	public void updateBooking(Booking booking) {
		bookingDAO.updateBooking(booking);
		
	}

	@Override
	public void deleteBooking(Long id) {
		bookingDAO.deleteBooking(id);
		
	}

	@Override
	public List<Location> getAllLocations() {
		List<Location> locations = bookingDAO.getAllLocations();
		return locations;
	}

	@Override
	public List<Class> getAllClassByLocation(Long id) {
		List<Class> classesByLocation = bookingDAO.getAllClassesByLocation(id);
		return classesByLocation;
	}

	@Override
	public Class getClassById(Long id) {
		return  bookingDAO.getClassById(id);
	}

	@Override
	public Booking retrieveBookingById(Long id) {
		// TODO Auto-generated method stub
		return bookingDAO.getBookingById(id);
	}

}
