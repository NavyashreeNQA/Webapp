package com.tyss.bookmydoctor.app.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name="rating_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="role")
	private String role;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	@Column(name="email", unique = true)
	private String email;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9._-]{3,}$")
	@Column(name="user_name", unique = true)
	private String username;
	
	@NotNull
	@Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&-+=()])(?=\\S+$).{8, 20}$")
	@Column(name="password")
	private String password;
	
	@NotNull
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}")
	@Column(name="phone", unique = true)
	private int phone;
}