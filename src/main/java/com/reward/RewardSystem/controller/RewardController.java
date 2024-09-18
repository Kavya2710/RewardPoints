package com.reward.RewardSystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reward.RewardSystem.Service.RewardService;
import com.reward.RewardSystem.model.RewardPoints;

@RestController
@RequestMapping("/rewards")
public class RewardController {
	
	@Autowired
	private RewardService rewardService;
	
	@PostMapping("/calculate/{customerId}")
	public void calculateRewards(@PathVariable String customerId, @RequestParam String startDate, @RequestParam String endDate) {
		LocalDate start=LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		rewardService.calculateAndSaveRewards(customerId, start, end);
	}
	@GetMapping("/{CustomerId}")
	public List<RewardPoints> getRewards(@PathVariable String customerId){
		return rewardService.getRewards(customerId);
	}
}
