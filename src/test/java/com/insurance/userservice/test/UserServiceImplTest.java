package com.insurance.userservice.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.entities.User;
import com.insurance.exceptions.ResourceNotFoundException;
import com.insurance.payloads.UserDTO;
import com.insurance.repository.UserRepo;
import com.insurance.serviceimpl.UserServiceImpl;

@ExtendWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Mock
	private UserRepo userRepo;
	
	

	@Test
	public void createUserTest() {
		
		User user1 = new User();
		user1.setUserId(11);
		user1.setUsername("xyz");
		user1.setPassword("mno");
		user1.setMobileNumber("8456213452");
		
		when(userRepo.save(user1)).thenReturn(user1);
		
		assertEquals(user1, userRepo.save(user1));
	}

	@Test
	public void deleteUserTest() {
		
		User user1 = new User();
		user1.setUserId(11);
		user1.setUsername("xyz");
		user1.setPassword("mno");
		user1.setMobileNumber("8456213452");
		
		userRepo.save(user1);
		
		userRepo.deleteById(user1.getUserId());
		
		Optional<User> actualUser = userRepo.findById(user1.getUserId());
		
		assertEquals("Optional.empty", actualUser);
	}
}
