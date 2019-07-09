/**
 * 
 */
package model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import security.UserAuthority;

/**
 * @author fabianwoodman
 * Model object for a Customer
 */

@Entity
@Table(name = "person")
@Proxy(lazy = false)
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String forenames;

	@Column(name = "last_name")
	private String surname;

	@Column(name = "username")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone_num")
	private String phoneNum;
	
	 @OneToMany(mappedBy="person")
	 private Set<Booking> booking;
	 
	 @OneToMany(mappedBy = "person", targetEntity = UserAuthority.class, fetch = FetchType.LAZY)
	 private Set<UserAuthority> authorities = new HashSet<UserAuthority>();
	 
	 @Column(name = "uac")
	private String uac;
	
	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

	/**
	 * getters and setters
	 * 
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	

	public Set<UserAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<UserAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public void addAuthority(UserAuthority auth) {
		if(null != auth)
		{
			auth.setUserLog(this);
			this.authorities.add(auth);
		}
	}
	
	public String getUac() {
		return uac;
	}

	public void setUac(String uac) {
		this.uac = uac;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", forenames=" + forenames + ", surname=" + surname + ", email=" + email
				+ ", password=" + password + ", phoneNum=" + phoneNum + "]";
	}
}
