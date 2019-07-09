/**
 * 
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import javax.persistence.Column;
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
 * @author fabianwoodman
 * Model object for a class
 */

@Entity
@Table(name = "class")
@Proxy(lazy = false)
public class Class implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/**
	 *TODO Foreign Key for Location_id
	 * 
	 */
	@OneToOne
	 @JoinColumn(name="location_id", nullable=false)
	 private Location location;
	
	/**
	 * TODO Foreign Key for Class_type_id
	 */
	@OneToOne
	 @JoinColumn(name="class_type_id", nullable=false)
	 private ClassType class_type;
	
	@Column(name="date_start")
	private Date date_start;
	
	@Column(name="date_end")
	private Date dateEnd;
	
	@Column(name="time_start")
	private Time timeStart;
	
	/**
	 * Class duration in minutes
	 */
	@Column(name="duration")
	private int duration;
	
	@Column(name="day_of_week")
	private int dayOfWeek;
	
	@Column(name="cancel_all")
	private Boolean cancelAll;
	
	@OneToMany(mappedBy="_class")
    private Set<Booking> booking;
	
	@OneToMany(mappedBy="_class")
	 private Set<TutorClass> tutorClass;

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ClassType getClass_type() {
		return class_type;
	}

	public void setClass_type(ClassType class_type) {
		this.class_type = class_type;
	}

	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Time getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Time timeStart) {
		this.timeStart = timeStart;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Boolean getCancelAll() {
		return cancelAll;
	}

	public void setCancelAll(Boolean cancelAll) {
		this.cancelAll = cancelAll;
	}
	
}
