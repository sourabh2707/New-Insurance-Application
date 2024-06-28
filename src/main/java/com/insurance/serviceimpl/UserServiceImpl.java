package com.insurance.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entities.User;
import com.insurance.exceptions.ResourceAlreadyExistsException;
import com.insurance.exceptions.ResourceNotFoundException;
import com.insurance.payloads.UserDTO;
import com.insurance.repository.UserRepo;
import com.insurance.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = dtoToUser(userDTO);
		User existedUser = userRepo.findByMobileNumber(user.getMobileNumber());
		if (existedUser == null) {
			User user1 = userRepo.save(user);
			return userToDto(user1);
		} else {
			throw new ResourceAlreadyExistsException("User", "Mobile Number", user.getMobileNumber());
		}

	}

	@Override
	public UserDTO changeUserPassword(UserDTO userDTO, int id) {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "User_Id", id));
		user.setPassword(userDTO.getPassword());
		User user1 = userRepo.save(user);
		return userToDto(user1);
	}

	@Override
	public List<UserDTO> fetchAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserDTO> userDTOs = users.stream().map(e -> userToDto(e)).collect(Collectors.toList());
		return userDTOs;
	}

	@Override
	public UserDTO fetchUserById(int id) {
		User user1 = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "User_Id", id));
		return userToDto(user1);
	}

	@Override
	public void dropUser(int id) {
		userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "User_Id", id));
		userRepo.deleteById(id);
	}

	// Method to convert dto to user
	public User dtoToUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		/*User user = new User();
		user.setUserId(userDTO.getUserId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setMobileNumber(userDTO.getMobileNumber());*/
		return user;
	}

	// Method to convert user to dto
	public UserDTO userToDto(User user) {
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		/*
		 * UserDTO userDTO = new UserDTO(); userDTO.setUserId(user.getUserId());
		 * userDTO.setUsername(user.getUsername());
		 * userDTO.setPassword(user.getPassword());
		 * userDTO.setMobileNumber(user.getMobileNumber());
		 */
		return userDTO;
	}
}
