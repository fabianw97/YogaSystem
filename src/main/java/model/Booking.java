/**
 * 
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * @author fabianwoodman
 * Model object for a booking
 *
 */

@Entity
@Table(name = "booking")
@Proxy(lazy = false)
public class Booking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Foreign Key for Customer_id
	 * One to many relationship
	 * A Customer can have one to many bookings
	 */
	 
	@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Person person;
	 /**
	  * Foreign Key for Class_id
	  * One to many relationship
	  * A Class can be booked one to many times
	  */
	 @OneToOne
	 @JoinColumn(name="class_id", nullable=false)
	 private Class _class;
	 
	 @Column(name="date_created")
	 private Date dateCreated;
	
	 @Column(name="date_start")
	 private Date dateStart;
	 
	 @Column(name="time_start")
	 private Time timeStart;
	 
	 @Column(name="time_end")
	 private Time timeEnd;
	 
	 @Column(name="is_cancelled")
	 private Boolean isCancelled;
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getCustomer() {
		return person;
	}

	public void setCustomer(Person customer) {
		this.person = customer;
	}

	public Class get_class() {
		return _class;
	}

	public void set_class(Class _class) {
		this._class = _class;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Time getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Time timeStart) {
		this.timeStart = timeStart;
	}

	public Time getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Time timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Boolean getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	 
}
