package com.insurance.service;

import java.util.List;


import com.insurance.payloads.PremiumDTO;

public interface PremiumService {
	
	//Create premium
	public PremiumDTO createPremium(PremiumDTO premiumDTO, int userId);
	
	//Get user with multiple premium details
	public List<PremiumDTO> fetchUserWithMultiplePremium(int userId);
	
}
