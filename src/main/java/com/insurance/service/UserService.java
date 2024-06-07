package com.insurance.service;

import java.util.List;

import com.insurance.payloads.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO userDTO);
	UserDTO changeUserPassword(UserDTO userDTO, int id);
	List<UserDTO> fetchAllUsers();
	UserDTO fetchUserById(int id);
	void dropUser(int id);
}
