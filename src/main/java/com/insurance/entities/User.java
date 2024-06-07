package com.insurance.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	
	private String username;

	@Column(nullable = false)
	@Pattern(regexp = "^[a-Az-Z0-9@#!&]+$")
	private String password;
	
	@Column(nullable = false, unique = true)
	@Pattern(regexp = "^[0-9]+$")
	private String mobileNumber;

}
