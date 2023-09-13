package com.example.model;

import java.time.LocalDate;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rewardsId;

	private int customerId;

	private String customerName;

	private Integer transactionAmount;

	@Nullable
	private Integer pointsAwarded;

	private LocalDate entryDate;

	public int getRewardsId() {
		return rewardsId;
	}

	public void setRewardsId(int rewardsId) {
		this.rewardsId = rewardsId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Integer transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Integer getPointsAwarded() {
		return pointsAwarded;
	}

	public void setPointsAwarded(Integer pointsAwarded) {
		this.pointsAwarded = pointsAwarded;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
}
