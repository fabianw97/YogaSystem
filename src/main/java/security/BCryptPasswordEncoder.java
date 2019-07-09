package security;

import org.springframework.security.crypto.bcrypt.BCrypt;

@SuppressWarnings("deprecation")
public class BCryptPasswordEncoder implements org.springframework.security.authentication.encoding.PasswordEncoder {

	@Override
	public String encodePassword(String rawPass, Object salt) {		
		return BCrypt.hashpw(rawPass, BCrypt.gensalt());
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {		
		return BCrypt.checkpw(rawPass, encPass);
	}
}