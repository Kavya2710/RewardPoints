package com.reward.RewardSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reward.RewardSystem.Service.RewardService;
import com.reward.RewardSystem.model.CustomerTransaction;
import com.reward.RewardSystem.model.RewardPoints;
import com.reward.RewardSystem.repository.CustomerTransactionRepository;

@SpringBootTest
class RewardSystemApplicationTests {

	@Autowired
	private RewardService rewardService;
	
	@Autowired
	private CustomerTransactionRepository transactionRepository;
	
	@Test
	public void testcalculatePoints() {
		double amount=120.0;
		int points=rewardService.calculatePoints(amount);
		assertEquals(90,points);
	}
	
	@Test
	public void testCalculateAndSaveRewards() {
		String customerId="cust1";
		LocalDate startDate=LocalDate.of(2024, 1,1);
		LocalDate endDate=LocalDate.of(2024, 3,31);
		
		CustomerTransaction transaction=new CustomerTransaction();
		transaction.setCustomerId(customerId);
		transaction.setAmount(120.0);
		transaction.setDate(LocalDate.of(2024, 1,15));
		transactionRepository.save(transaction);
		
		rewardService.calculateAndSaveRewards(customerId, startDate, endDate);
		
		List<RewardPoints> rewards=rewardService.getRewards(customerId);
		assertFalse(rewards.isEmpty());
		assertEquals(90,rewards.get(0).getPoints());
	}
}
