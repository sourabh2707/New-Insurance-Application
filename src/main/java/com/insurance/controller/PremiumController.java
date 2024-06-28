package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.payloads.PremiumDTO;
import com.insurance.serviceimpl.PremiumServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/premium")
public class PremiumController {

	@Autowired
	private PremiumServiceImpl premiumServiceImpl;

	@PostMapping("/save/userid/{id}")
	public ResponseEntity<PremiumDTO> savePremium(@RequestBody PremiumDTO premiumDTO, @PathVariable("id") int userId) {
		PremiumDTO savedPremiumDTO = premiumServiceImpl.createPremium(premiumDTO, userId);
		return new ResponseEntity<PremiumDTO>(savedPremiumDTO, HttpStatus.CREATED);
	}

	@GetMapping("/user/{id}/premiumlist")
	public ResponseEntity<List<PremiumDTO>> getuserPremiumList(@PathVariable("id") int userId) {
		List<PremiumDTO> userPremiumList = premiumServiceImpl.fetchUserWithMultiplePremium(userId);
		return new ResponseEntity<List<PremiumDTO>>(userPremiumList, HttpStatus.OK);
	}
}
