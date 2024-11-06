package com.rewardPointsApp.service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rewardPointsApp.model.RewardReport;
import com.rewardPointsApp.model.Transaction;

@Service
public class RewardService {
	/*
	 * public int calculatePoints(Double amount) { int points = 0;
	 * 
	 * if (amount > 100) { points += (amount.intValue() - 100) * 2 + 50; } else if
	 * (amount > 50) { points += (amount.intValue() - 50) * 1; }
	 * 
	 * return points; }
	 */
    
  

    public Map<String, Integer> calculateMonthlyPoints(List<Transaction> transactions) {
        Map<String, Integer> monthlyPoints = new HashMap<>();
        for (Transaction transactionDate : transactions) {
            String month = transactionDate.getTransactionDate().getMonth().toString();
            int points = calculatePoints(transactionDate.getAmount());
            monthlyPoints.merge(month, points, Integer::sum);
        }
        return monthlyPoints;
    }
    
    
    public RewardReport generateRewardReport(Long customerId) {
        // Fetch transactions for the customer (replace with actual data retrieval)
        List<Transaction> transactions = getTransactionsByCustomerId(customerId);
        Map<String, Integer> monthlyPoints = calculateMonthlyPoints(transactions);
        int totalPoints = monthlyPoints.values().stream().mapToInt(Integer::intValue).sum();
        return new RewardReport(customerId, monthlyPoints, totalPoints, transactions);
    }
    
    public List<RewardReport> generateAllRewardReports() {
        List<Long> customerIds = getAllCustomerIds(); // Retrieve all customer IDs
        List<RewardReport> reports = new ArrayList<>();
        for (Long customerId : customerIds) {
            reports.add(generateRewardReport(customerId));
        }
        return reports;
    }
    
    private List<Transaction> getTransactionsByCustomerId(Long customerId) {
        // This should retrieve transactions from a database or data source
        // Example mock data
        return Arrays.asList(
            new Transaction(1L, customerId, LocalDate.of(2024, 8, 10), 120.0),
            new Transaction(2L, customerId, LocalDate.of(2024, 8, 15), 90.0),
            new Transaction(3L, customerId, LocalDate.of(2024, 9, 5), 110.0)
        );
    }
    
    private List<Long> getAllCustomerIds() {
        // This should retrieve all unique customer IDs from a database or data source
        // Example mock data
        return List.of(1L, 2L, 3L);
    }
    
    public Map<Long, Map<String, Integer>> calculateAllCustomerPoints(List<Transaction> transactions) {
        Map<Long, Map<String, Integer>> allCustomerPoints = new HashMap<>();

        for (Transaction transaction : transactions) {
            Long customerId = transaction.getCustomerId();
            String month = transaction.getTransactionDate().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            int points = calculatePoints(transaction.getAmount());

            // Get or create monthly points map for the customer
            Map<String, Integer> monthlyPoints = allCustomerPoints.computeIfAbsent(customerId, k -> new HashMap<>());
            monthlyPoints.merge(month, points, Integer::sum);
        }

        return allCustomerPoints;
    }
    
    private int calculatePoints(double amount) {
        int points = 0;
        if (amount > 50) points += (int) (amount - 50);
        if (amount > 100) points += (int) (amount - 100);
        return points;
    }
    
    
    
}

