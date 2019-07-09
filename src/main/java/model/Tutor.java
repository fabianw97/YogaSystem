package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * @author fabianwoodman Model object for a Tutor
 *
 */

@Entity
@Table(name = "tutor")
@Proxy(lazy = false)
public class Tutor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private Person person;

	/**
	 * Foreign Key for user_id 
	 * 
	 **/
	
	@OneToMany(mappedBy="tutor")
	 private Set<TutorClass> tutorClass;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
