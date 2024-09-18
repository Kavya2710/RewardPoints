package com.reward.RewardSystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.RewardSystem.model.CustomerTransaction;

public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Long>{
	List<CustomerTransaction>findCustomerIdAndDateBetween(String customerId, LocalDate startDate, LocalDate endDate);
}



