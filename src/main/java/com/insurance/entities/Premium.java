package com.insurance.entities;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Premium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "premium_id")
	private int premiumId;
	
	@Column(name = "type", length = 50)
	private String premiumType;
	
	@Column(name = "amount")
	private long premiumAmount;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
