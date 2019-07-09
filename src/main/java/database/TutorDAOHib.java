package database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import model.Tutor;
import model.TutorClass;

@Repository
public class TutorDAOHib implements TutorDAO {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void createTutor(Tutor tutor) {
		Session session = sessionFactory.getCurrentSession();
		session.save(tutor);
	}

	@Override
	public List<TutorClass> getTutorClasses(Long id) {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(TutorClass.class);
		@SuppressWarnings("unchecked")
		List<TutorClass> classes = (List<TutorClass>) createCriteria.add(Restrictions.eq("tutor.id", id)).list();
		return classes;
	}

}
