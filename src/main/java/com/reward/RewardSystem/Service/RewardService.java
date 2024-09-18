package com.reward.RewardSystem.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reward.RewardSystem.model.CustomerTransaction;
import com.reward.RewardSystem.model.RewardPoints;
import com.reward.RewardSystem.repository.CustomerTransactionRepository;
import com.reward.RewardSystem.repository.RewardPointsRepository;

@Service
public class RewardService {
	@Autowired
	private CustomerTransactionRepository transactionRepository;
	
	@Autowired
	private RewardPointsRepository rewardPointsRepository;
	
	public int calculatePoints(double amount)
	{
		int points=0;
		if(amount>100) {
			points+=(amount-100)*2;
			amount=100;
		}
		if(amount>50) {
			points+=(amount-50);
		}
		return points;
	}
	
	public void calculateAndSaveRewards(String customerId, LocalDate startDate, LocalDate endDate) {
		List<CustomerTransaction> transactions=transactionRepository.findCustomerIdAndDateBetween(customerId, startDate, endDate);
		Map<String, Integer> monthlyRewards=new HashMap<>();
		
		for(CustomerTransaction transaction:transactions) {
			String month=transaction.getDate().getMonth().toString();
			int points=calculatePoints(transaction.getAmount());
			monthlyRewards.put(month, monthlyRewards.getOrDefault(month,0)+points);
		}
		for(Map.Entry<String,Integer>entry: monthlyRewards.entrySet()) {
			RewardPoints rewardPoints=new RewardPoints();
			rewardPoints.setCustomerId(customerId);
			rewardPoints.setMonth(entry.getKey());
			rewardPoints.setYear(startDate.getYear());
			rewardPoints.setPoints(entry.getValue());
			rewardPointsRepository.save(rewardPoints);
		}
	}

	public List<RewardPoints> getRewards(String customerId){
		return rewardPointsRepository.findByCustomerId(customerId);
	}
}
