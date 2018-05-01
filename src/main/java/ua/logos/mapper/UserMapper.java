package ua.logos.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.logos.domain.EditRequest;
import ua.logos.domain.RegisterRequest;
import ua.logos.entity.enums.UserRole;

public interface UserMapper {

	public static User toSecurityUser(ua.logos.entity.User user) {
		return new User(//user.getEmail(), 
						user.getId().toString(),
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
	
	public static EditRequest userToEditRequest (ua.logos.entity.User user) {
		EditRequest request = new EditRequest();
		request.setEmail(user.getEmail());
		request.setPassword(user.getPassword());
		request.setFirstName(user.getUserProfile().getFirstName());
		request.setLastName(user.getUserProfile().getLastName());
		request.setDescription(user.getUserProfile().getDescription());
		request.setAge(user.getUserProfile().getAge());
		request.setId(user.getId());
		
		return request;
	}
}
