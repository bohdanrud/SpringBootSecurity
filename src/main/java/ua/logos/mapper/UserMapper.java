package ua.logos.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.logos.domain.RegisterRequest;
import ua.logos.entity.enums.UserRole;

public interface UserMapper {

	public static User toSecurityUser(ua.logos.entity.User user) {
		return new User(user.getEmail(), 
						user.getPassword(), 
						AuthorityUtils.createAuthorityList(String.valueOf(user.getRole())));
	}
	
	public static ua.logos.entity.User registerRequestToUser(RegisterRequest request){
		ua.logos.entity.User user = new ua.logos.entity.User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(UserRole.ROLE_USER);
		return user;
	}
	
}
