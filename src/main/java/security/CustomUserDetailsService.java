package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Person;
import services.UserService;

@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Person customer = userService.retrieveUserByEmail(username);

		if (customer == null) {
			throw new UsernameNotFoundException("No such user was found: "
					+ username);
		} else if (customer.getAuthorities().isEmpty()) {
			throw new UsernameNotFoundException("User " + username
					+ " has no authorities");
		}
		
		User user = new User(customer);
		
		@SuppressWarnings("unused")
		boolean accountNonExpired = true;
		@SuppressWarnings("unused")
		boolean credentialsNnoExpired = true;
		@SuppressWarnings("unused")
		boolean accountNonLocked = true;

		return user;
	}

}