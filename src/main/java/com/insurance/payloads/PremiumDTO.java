package com.insurance.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PremiumDTO {

	private int premiumId;

	@NotEmpty
	@NotBlank
	private String premiumType;


	@NotEmpty
	@NotBlank
	private long premiumAmount;

	//private UserDTO userDTO;
}
