package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.LocationDAOHib;
import model.Location;
/**
 * 
 * @author fabianwoodman
 *
 */
@Service
@Transactional
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	@Qualifier("locationDAOHib")
	private LocationDAOHib locationDAO;

	@Override
	public Location getLocationById(Long id) {
		return locationDAO.getLocationById(id);
	}
	
	

}
