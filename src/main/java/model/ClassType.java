/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * @author fabianwoodman
 * Model object for class type
 *
 */
@Entity
@Table(name = "class_type")
@Proxy(lazy = false)
public class ClassType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "class_name")
	private String className;
	
	@Column(name="class_description")
	private String classDescription;
	
	@OneToMany(mappedBy="class_type")
    private Set<Class> _class;

	public Set<Class> get_class() {
		return _class;
	}

	public void set_class(Set<Class> _class) {
		this._class = _class;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}
	

}
