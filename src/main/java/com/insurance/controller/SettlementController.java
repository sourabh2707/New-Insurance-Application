package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.payloads.SettlementDTO;
import com.insurance.serviceimpl.SettlementServiceImpl;

@RestController
@RequestMapping("/settlement")
public class SettlementController {

	@Autowired
	private SettlementServiceImpl settlementServiceImpl;
	
	@PostMapping("/save/user/{id}")
	public ResponseEntity<SettlementDTO> saveSettlement(@RequestBody SettlementDTO settlementDTO, @PathVariable("id") int userId){
		SettlementDTO savedSettlementDTO = settlementServiceImpl.createSettlement(settlementDTO, userId);
		return new ResponseEntity<SettlementDTO>(savedSettlementDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/settlement/userid/{id}")
	public String deleteSettlement(@PathVariable("id") int userId) {
		settlementServiceImpl.dropSettlement(userId);
		return "Deleted successfully";
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<SettlementDTO>> getAllSettlement(){
		List<SettlementDTO> settlementList =  settlementServiceImpl.fetchAllSettlement();
		return new ResponseEntity<List<SettlementDTO>>(settlementList,HttpStatus.OK);
	}
	
}
