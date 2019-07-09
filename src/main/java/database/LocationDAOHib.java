package database;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import model.Location;
/**
 * 
 * @author fabianwoodman
 *
 */
@Repository
public class LocationDAOHib implements LocationDAO{
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * @return Location object
	 * @param Location id
	 */
	@Override
	public Location getLocationById(Long id) {
		return (Location) sessionFactory.getCurrentSession().load(Location.class,id);
	}

}
