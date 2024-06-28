package com.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurance.entities.Premium;

@Repository

public interface PremiumRepo extends JpaRepository<Premium, Integer> {
	
	@Query(value = "select * from premium where user_id = ?1", nativeQuery = true)
	List<Premium> getPremiumByUserId(int userId);
}
