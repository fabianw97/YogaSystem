package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.ClassDAOHib;
import model.Class;
import model.ClassType;
import model.TutorClass;
/**
 * 
 * @author fabianwoodman
 *
 */
@Service
@Transactional
public class ClassServiceImpl implements ClassService{
	
	@Autowired
	@Qualifier("classDAOHib")
	private ClassDAOHib classDAO;

	@Override
	public ClassType getClassTypeById(Long id) {
		return classDAO.getClassTypeById(id);
	}

	@Override
	public void createClass(Class _class, TutorClass tutorClass) {
		classDAO.createNewClass(_class, tutorClass);	
	}

	@Override
	public List<ClassType> getAllClassTypes() {
		List<ClassType> allClassTypes = classDAO.getAllClassTypes();
		return allClassTypes;
	}

	@Override
	public void createClassType(ClassType classType) {
		classDAO.createNewClassType(classType);
		
	}

}
