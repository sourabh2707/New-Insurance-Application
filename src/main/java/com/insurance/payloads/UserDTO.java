package com.insurance.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

	private int userId;
	
	@Size(min = 4, max = 20)
	@NotEmpty
	private String username;
	
	@Size(min = 4, max = 20)
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9@#$!&*%]+$")
	private String password;
	
	@Size(min = 10, max = 10)
	@Pattern(regexp = "^[0-9]+$")
	@NotEmpty
	private String mobileNumber;
	
	@Email(regexp = "^[a-zA-Z0-9@.]+$")
	@NotEmpty
	private String email;
}
