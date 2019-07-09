/**
 * 
 */
package services;

import java.util.List;

import model.ClassType;
import model.TutorClass;
import model.Class;

/**
 * @author fabianwoodman
 *
 */
public interface ClassService {
	
	public ClassType getClassTypeById(Long id);
	
	public List<ClassType> getAllClassTypes();
	
	public void createClass(Class _class,TutorClass tutorClass);
	
	//public void createTutorClass(TutorClass tutorClass);
	
	public void createClassType(ClassType classType);

}
