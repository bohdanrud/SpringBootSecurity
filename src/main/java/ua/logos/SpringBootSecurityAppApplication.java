package ua.logos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import ua.logos.entity.User;
import ua.logos.entity.enums.UserRole;
import ua.logos.repository.UserRepository;

@SpringBootApplication
public class SpringBootSecurityAppApplication extends SpringBootServletInitializer{

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SpringBootSecurityAppApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootSecurityAppApplication.class, args);
	addUsers(context);
	}
	
	
	static void addUsers(ConfigurableApplicationContext context) {
		String email = "admin@gmail.com";
		String password = "123";
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		User user = userRepository.findUserByEmail(email);
		
		if (user == null) {
			PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
			user = new User();
			user.setEmail(email);
			user.setPassword(passwordEncoder.encode(password));
			user.setRole(UserRole.ROLE_ADMIN);
			userRepository.save(user);
			
			user = new User();
			user.setEmail("user@gmail.com");
			user.setPassword(passwordEncoder.encode(password));
			user.setRole(UserRole.ROLE_USER);
			userRepository.save(user);
		}
	}
}
