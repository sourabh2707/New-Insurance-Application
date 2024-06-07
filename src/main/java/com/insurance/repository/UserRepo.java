package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByMobileNumber(String mobileNumber);
}
