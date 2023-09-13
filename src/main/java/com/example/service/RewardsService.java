package com.example.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Reward;
import com.example.repo.RewardsRepository;

@Service
public class RewardsService {

	@Autowired
	private RewardsRepository repository;

	/**
	 * This operation calculates points awarded for a customer based on the transaction amount.
	 * If points were awarded data is ingested into the Reward table showing the points awarded success message.
	 * If no points were awarded a message stating the same will be sent as a response.
	 */
	public String addRewardPoints(@RequestBody Reward reward) {
		int transactionAmount = reward.getTransactionAmount();
		int rewardPoints = 0;

		if (transactionAmount > 50 && transactionAmount <= 100) {
			rewardPoints = transactionAmount - 50;
		} else if (transactionAmount > 100) {
			rewardPoints = 50 + (2 * (transactionAmount - 100));
		}

		if (rewardPoints > 0) {
			reward.setPointsAwarded(rewardPoints);
			reward.setEntryDate(LocalDate.now());
			repository.save(reward);
			return rewardPoints + " Points Awarded to the Customer " + reward.getCustomerName();
		}

		return "No Points Were Awarded For This Transaction";
	}

	/**
	 * This Operation is used to retrieve Points Awarded to all the Customers on monthly basis.
	 * It returns points data in a hierarchical way for each customer --> each month.
	 */
	public Map<String, Map<String, Integer>> retrieveAllCustomersRewards() {
		List<Reward> allRewards = repository.findAll();
		Map<String, Map<String, Integer>> pointsAwardedByMonth = null;
		if (!allRewards.isEmpty()) {
			pointsAwardedByMonth = allRewards.stream()
					.collect(Collectors.groupingBy(reward -> reward.getCustomerName(),
							Collectors.groupingBy(reward -> YearMonth.from(reward.getEntryDate()).toString(),
									TreeMap::new, Collectors.summingInt(reward -> reward.getPointsAwarded()))));
		}
		return pointsAwardedByMonth;
	}

	/**
	 * This Operation is used to retrieve Points Awarded to a single Customer on monthly basis.
	 * It returns monthly points data for a single customer.
	 */
	public Map<String, Integer> retrieveCustomerRewardPoints(int customerId) {
		List<Reward> allRewards = repository.findByCustomerId(customerId);
		Map<String, Integer> pointsAwardedByMonth = null;
		if (!allRewards.isEmpty()) {
			pointsAwardedByMonth = allRewards.stream()
					.collect(Collectors.groupingBy(reward -> YearMonth.from(reward.getEntryDate()).toString(),
							TreeMap::new, Collectors.summingInt(reward -> reward.getPointsAwarded())));
		}
		return pointsAwardedByMonth;
	}
}
