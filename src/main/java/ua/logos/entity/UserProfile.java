package ua.logos.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "user_profile")
@NoArgsConstructor
@Getter
@Setter
public class UserProfile extends BaseEntity{
	
	private String firstName;
	
	private String lastName;
	
	private String age;
	
	private String description;

}
