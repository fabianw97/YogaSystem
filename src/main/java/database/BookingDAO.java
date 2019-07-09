package database;

import java.util.List;

import model.Booking;
import model.Location;
import model.Class;

public interface BookingDAO {
	
	public void createBooking(Booking booking);

	public void updateBooking(Booking booking);
	
	public void deleteBooking(Long id);
	
	public List<Location> getAllLocations();
	
	public List<Class> getAllClassesByLocation(Long id);
	
	public Class getClassById(Long id);
	
	public Booking getBookingById(Long id);
	
	
}
