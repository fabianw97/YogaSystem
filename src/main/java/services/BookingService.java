package services;

import java.util.List;

import model.Booking;
import model.Location;
import model.Class;

public interface BookingService {
	
	public void createBooking(Booking booking);
	
	public void updateBooking(Booking booking);
	
	public void deleteBooking(Long id);
	
	public Booking retrieveBookingById(Long id);
	
	public List<Location> getAllLocations();
	
	public List<Class> getAllClassByLocation(Long id);
	
	public Class getClassById(Long id);

}
