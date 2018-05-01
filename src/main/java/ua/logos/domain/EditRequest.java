package ua.logos.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EditRequest {
	
	private int id;
	
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String age;
	
	private String description;

}
