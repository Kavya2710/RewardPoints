package com.reward.RewardSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.RewardSystem.model.RewardPoints;

public interface RewardPointsRepository extends JpaRepository<RewardPoints, Long> {
	List<RewardPoints> findByCustomerId(String customerId);
}