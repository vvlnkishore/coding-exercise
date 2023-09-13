package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Reward;

public interface RewardsRepository extends JpaRepository<Reward, Integer> {

	List<Reward> findByCustomerId(int customerId);
}
