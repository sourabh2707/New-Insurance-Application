package com.insurance.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entities.Settlement;
import com.insurance.entities.User;
import com.insurance.exceptions.ResourceNotFoundException;
import com.insurance.payloads.SettlementDTO;
import com.insurance.repository.SettlementRepo;
import com.insurance.repository.UserRepo;
import com.insurance.service.SettlementService;

@Service
public class SettlementServiceImpl implements SettlementService {

	@Autowired
	private SettlementRepo settlementRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SettlementDTO createSettlement(SettlementDTO settlementDTO, int userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));
		Settlement settlement = modelMapper.map(settlementDTO, Settlement.class);
		settlement.setUser(user);
		settlement.setDateTime(LocalDateTime.now());
		Settlement createdSettlement = settlementRepo.save(settlement);
		return modelMapper.map(createdSettlement, SettlementDTO.class);
	}

	@Override
	public void dropSettlement(int userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));
		if(user !=null) {
			settlementRepo.dropSettlementByUserId(userId);
		}
	}

	@Override
	public List<SettlementDTO> fetchAllSettlement() {
		List<Settlement> settlement = settlementRepo.findAll();
		List<SettlementDTO> settlementDTOList = settlement.stream().map(e -> modelMapper.map(e, SettlementDTO.class))
				.collect(Collectors.toList());
		return settlementDTOList;
	}
}
