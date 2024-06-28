package com.insurance.payloads;

import java.util.List;

import com.insurance.entities.Premium;
import com.insurance.entities.Settlement;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserDTO {

	private int userId;

	@Size(min = 4, max = 20, message = "Username should have min 4 and max 20 characters!")
	@NotEmpty
	@NotBlank
	private String username;

	@Size(min = 4, max = 20, message = "Password should have min 4 and max 20 characters!")
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9@#$!&*%]+$")
	private String password;

	@Size(min = 10, max = 10, message = "Mobile number should be of 10 digits!")
	@Pattern(regexp = "^[0-9]+$")
	@NotBlank
	@NotEmpty
	private String mobileNumber;

	@Email(regexp = "^[a-zA-Z0-9@.]+$")
	@NotBlank
	@NotEmpty
	private String email;

	private List<PremiumDTO> premium;

	private List<SettlementDTO> settlement;
}
