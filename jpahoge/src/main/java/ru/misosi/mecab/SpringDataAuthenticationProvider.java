package ru.misosi.mecab;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SpringDataAuthenticationProvider implements AuthenticationProvider {
	private MessageDigestPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
	
	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		String name = auth.getName();
		String password = (String) auth.getCredentials();
		
		User user = (User) userService.loadUserByUsername(name);
		if (user == null) {
			throw new BadCredentialsException("Username not found");
		}
		
		if (!passwordEncoder.isPasswordValid(user.getPassword(), password, "")) {
			throw new BadCredentialsException("Password is invalid");
		}
		
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		return new UsernamePasswordAuthenticationToken(name, password, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}
	

}
