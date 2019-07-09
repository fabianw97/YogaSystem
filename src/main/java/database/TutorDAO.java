package database;
/**
 * @author fabianwoodman
 */

import java.util.List;
import model.Tutor;
import model.TutorClass;

public interface TutorDAO {
	
	public void createTutor(Tutor tutor);
	
	public List<TutorClass> getTutorClasses(Long id);

}
