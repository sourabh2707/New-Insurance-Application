package com.insurance.service;

import java.util.List;

import com.insurance.payloads.SettlementDTO;

public interface SettlementService {

	// Create settlement
	SettlementDTO createSettlement(SettlementDTO settlementDTO, int userId);
	
	// Delete settlement by user id
	void dropSettlement(int userId);
	
	// Get all settelment
	List<SettlementDTO> fetchAllSettlement();
	
}
