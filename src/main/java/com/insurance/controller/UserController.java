package com.insurance.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entities.User;
import com.insurance.exceptions.ResourceNotFoundException;
import com.insurance.payloads.UserDTO;
import com.insurance.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/save")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
		UserDTO userDTO1 = userServiceImpl.createUser(userDTO);
		return new ResponseEntity<>(userDTO1, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserDTO> updatePassword(@RequestBody UserDTO userDTO, @PathVariable("id") int userId) {
		UserDTO userDTO1 = userServiceImpl.changeUserPassword(userDTO, userId);
		return new ResponseEntity<>(userDTO1,HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> userDTOs = userServiceImpl.fetchAllUsers();
		return new ResponseEntity<>(userDTOs,HttpStatus.OK);
	}

	@GetMapping("/getuser/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int userId) {
		UserDTO userDTO1 = userServiceImpl.fetchUserById(userId);
		return new ResponseEntity<>(userDTO1, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int userId) {
		userServiceImpl.dropUser(userId);
		return String.format("User with userId : %s has been successfully deleted", userId);
	}

}
