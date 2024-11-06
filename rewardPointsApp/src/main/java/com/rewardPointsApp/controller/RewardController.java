package com.rewardPointsApp.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewardPointsApp.model.RewardReport;
import com.rewardPointsApp.model.Transaction;
import com.rewardPointsApp.service.RewardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/rewards")
@Tag(name = "Rewards API", description = "API for managing reward points")
public class RewardController {
    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @Operation(summary = "Get reward points for a specific customer")
    @GetMapping("/{customerId}")
    public ResponseEntity<Map<String, Integer>> getCustomerRewards(@PathVariable Long customerId) {
        
    	List<Transaction> transactions = Arrays.asList(
    		    new Transaction(1L, customerId, LocalDate.of(2024, 8, 10), 120.0),
    		    new Transaction(2L, customerId, LocalDate.of(2024, 8, 15), 90.0),
    		    new Transaction(3L, customerId, LocalDate.of(2024, 9, 5), 110.0)
    		);

        Map<String, Integer> rewards = rewardService.calculateMonthlyPoints(transactions);
        return ResponseEntity.ok(rewards);
    }
    
    @Operation(summary = "Demo url - fallback route")
    @GetMapping("/fallback")
    public ResponseEntity<String> fallback() {
        return ResponseEntity.ok("This is a fallback route. Please use /api/rewards/{customerId}");
    }
    
    @Operation(summary = "Get all customer rewards")
    @GetMapping("/all")
    public ResponseEntity<Map<Long, Map<String, Integer>>> getAllCustomerRewards() {
       
        List<Transaction> transactions = List.of(
            new Transaction(1L, 1L, LocalDate.of(2024, 8, 10), 120.0),
            new Transaction(2L, 2L, LocalDate.of(2024, 8, 15), 90.0),
            new Transaction(3L, 1L, LocalDate.of(2024, 9, 5), 110.0),
            new Transaction(4L, 2L, LocalDate.of(2024, 9, 20), 140.0)
        );

        Map<Long, Map<String, Integer>> allRewards = rewardService.calculateAllCustomerPoints(transactions);
        return ResponseEntity.ok(allRewards);
    }

    @Operation(summary = "Get reward report for a specific customer by customer ID")
    @GetMapping("/{customerId}/report")
    public ResponseEntity<RewardReport> getCustomerRewardReport(@PathVariable Long customerId) {
        RewardReport report = rewardService.generateRewardReport(customerId);
        return ResponseEntity.ok(report);
    }

    @Operation(summary = "Get reward reports for all customers")
    @GetMapping("/report")
    public ResponseEntity<List<RewardReport>> getAllCustomersRewardReports() {
        List<RewardReport> reports = rewardService.generateAllRewardReports();
        return ResponseEntity.ok(reports);
    }
}

