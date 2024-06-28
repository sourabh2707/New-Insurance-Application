package com.insurance.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SettlementDTO {

	private int settlementId;

	private String details;

	//private UserDTO userDTO;
}
