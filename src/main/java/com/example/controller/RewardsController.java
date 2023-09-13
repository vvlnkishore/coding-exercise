package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Reward;
import com.example.service.RewardsService;

@RestController
@RequestMapping("/rewards")
public class RewardsController {

	@Autowired
	private RewardsService service;

	@PostMapping("/add-points")
	public String addRewardPoints(@RequestBody Reward reward) {
		return service.addRewardPoints(reward);
	}

	@GetMapping("/retrieve-points")
	public Map<String, Map<String, Integer>> retrieveAllRewardPoints() {
		return service.retrieveAllCustomersRewards();
	}

	@GetMapping("/retrieve-points/{id}")
	public Map<String, Integer> retrieveCustomerRewardPoints(@PathVariable("id") int customerId) {
		return service.retrieveCustomerRewardPoints(customerId);
	}
}
