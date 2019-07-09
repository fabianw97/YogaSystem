/**
 * 
 */
package database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import model.Class;
import model.ClassType;
import model.TutorClass;

/**
 * @author fabianwoodman
 *
 */
@Repository
public class ClassDAOHib implements ClassDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public ClassType getClassTypeById(Long id) {
		return (ClassType) sessionFactory.getCurrentSession().load(ClassType.class, id);
	}

	@Override
	public void createNewClass(Class _class, TutorClass tutorClass) {
		Session session = sessionFactory.getCurrentSession();
		session.save(_class);
		session.save(tutorClass);
	}

	@Override
	public List<ClassType> getAllClassTypes() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ClassType.class);
		@SuppressWarnings("unchecked")
		List<ClassType> classTypes = criteria.list();
		return classTypes;
	}

	@Override
	public void createNewClassType(ClassType classType) {
		Session session = sessionFactory.getCurrentSession();
		session.save(classType);
	}

	@Override
	public void createTutorClass(TutorClass[] tutorClass) {
		Session session = sessionFactory.getCurrentSession();
		for (TutorClass t : tutorClass) {
			session.save(t);
		}
	}

}
