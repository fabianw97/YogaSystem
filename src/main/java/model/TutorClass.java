/**
 * 
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * @author fabianwoodman
 *
 */
@Entity
@Table(name = "tutor_class")
@Proxy(lazy = false)
public class TutorClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "tutor_id", nullable = false)
	private Tutor tutor;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "class_id", nullable = false)
	private Class _class;

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Class get_class() {
		return _class;
	}

	public void set_class(Class _class) {
		this._class = _class;
	}	

}
