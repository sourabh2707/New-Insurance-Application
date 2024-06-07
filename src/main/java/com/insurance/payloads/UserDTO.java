package com.insurance.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

	private int userId;
	private String username;
	private String password;
	private String mobileNumber;
}
