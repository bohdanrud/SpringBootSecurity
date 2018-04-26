package ua.logos.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public interface UserMapper {

	public static User toSecurityUser(ua.logos.entity.User user) {
		return new User(user.getEmail(), 
						user.getPassword(), 
						AuthorityUtils.createAuthorityList(String.valueOf(user.getRole())));
	}
	
}
