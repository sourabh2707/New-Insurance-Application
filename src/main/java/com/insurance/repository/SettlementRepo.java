package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurance.entities.Settlement;

@Repository
public interface SettlementRepo extends JpaRepository<Settlement, Integer> {

	@Query(value="Delete from settlement where user_id = ?1", nativeQuery = true)
	public void dropSettlementByUserId(int userId);
	
}
