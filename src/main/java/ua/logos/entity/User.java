package ua.logos.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.entity.enums.UserRole;

@Entity
@Table(name = "user", indexes = @Index(columnList = "email"))
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	private UserRole role;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_profile_id")
	private UserProfile userProfile = new UserProfile();
	
	private String token;

}
