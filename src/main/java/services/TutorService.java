package services;

import java.util.List;
import model.Tutor;
import model.TutorClass;


public interface TutorService {
	
	public void createTutor(Tutor tutor);
	
	public List<TutorClass> getTutorClasses(Long id);

}
