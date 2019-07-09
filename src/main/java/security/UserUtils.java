package security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

	public static User getLoggedInUser() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		return (User) (null != auth ? auth.getPrincipal() : null);
	}

}
