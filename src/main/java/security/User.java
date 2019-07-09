package security;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import model.Person;

@SuppressWarnings("serial")
public class User implements UserDetails {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	private Person person;

	public User(Person person) {
		this.setPerson(person);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getPerson().getAuthorities();
	}

	@Override
	public String getPassword() {
		return person.getPassword();
	}

	@Override
	public String getUsername() {
		return person.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}