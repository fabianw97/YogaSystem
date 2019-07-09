package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.TutorDAOHib;
import model.Tutor;
import model.TutorClass;

/**
 * 
 * @author fabianwoodman
 *
 */
@Service
@Transactional
public class TutorServiceImpl implements TutorService {
	
	@Autowired
	@Qualifier("tutorDAOHib")
	private TutorDAOHib tutorDAO;

	@Override
	public void createTutor(Tutor tutor) {
		tutorDAO.createTutor(tutor);
		
	}

	@Override
	public List<TutorClass> getTutorClasses(Long id) {
		List<TutorClass> tutorClasses = tutorDAO.getTutorClasses(id);
		return tutorClasses;
	}

}
