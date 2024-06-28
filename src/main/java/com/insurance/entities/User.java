package com.insurance.entities;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

	@Column(unique = true, length = 20)
	private String username;

	@Column(length = 20)
	private String password;

	@Column(unique = true, length = 10)
	private String mobileNumber;

	@Column(unique = true)
	private String email;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Premium> premium;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Settlement> settlement;
}
