package com.insurance.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entities.Premium;
import com.insurance.entities.User;
import com.insurance.exceptions.ResourceNotFoundException;
import com.insurance.payloads.PremiumDTO;
import com.insurance.repository.PremiumRepo;
import com.insurance.repository.UserRepo;
import com.insurance.service.PremiumService;

@Service
public class PremiumServiceImpl implements PremiumService {

	@Autowired
	private PremiumRepo premiumRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PremiumDTO createPremium(PremiumDTO premiumDTO, int userId) {
		Premium createdPremium = null;
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		if (user != null) {
			Premium premium = modelMapper.map(premiumDTO, Premium.class);
			premium.setUser(user);
			createdPremium = premiumRepo.save(premium);
		}
		return modelMapper.map(createdPremium, PremiumDTO.class);
	}

	@Override
	public List<PremiumDTO> fetchUserWithMultiplePremium(int userId) {
		premiumRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserID", userId));
//		List<Integer> list = new ArrayList<>();
//		list.add(userId);
		// List<Premium> premiumList = premiumRepo.findAllById(list);
		List<Premium> premiumList = premiumRepo.getPremiumByUserId(userId);
		List<PremiumDTO> userListWithPremium = premiumList.stream().map(e -> modelMapper.map(e, PremiumDTO.class))
				.collect(Collectors.toList());

		return userListWithPremium;
	}

}
