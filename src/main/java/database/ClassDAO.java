package database;

import java.util.List;
import model.Class;
import model.ClassType;
import model.TutorClass;

public interface ClassDAO {
	
	public ClassType getClassTypeById(Long id);
	
	public List<ClassType> getAllClassTypes();
	
	public void createNewClass(Class _class, TutorClass tutorClass);
	
	public void createTutorClass(TutorClass[] tutorClass);
	
	public void createNewClassType(ClassType classType);
}
