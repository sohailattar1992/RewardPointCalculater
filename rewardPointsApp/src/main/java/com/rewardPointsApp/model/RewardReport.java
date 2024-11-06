package com.rewardPointsApp.model;

import java.util.List;
import java.util.Map;

public class RewardReport {
    private Long customerId;
    private Map<String, Integer> monthlyPoints;
    private int totalPoints;
    private List<Transaction> transactions;

    public RewardReport(Long customerId, Map<String, Integer> monthlyPoints, int totalPoints, List<Transaction> transactions) {
        this.customerId = customerId;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
        this.transactions = transactions;
    }

    // Getters
    public Long getCustomerId() {
        return customerId;
    }

    public Map<String, Integer> getMonthlyPoints() {
        return monthlyPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Setters
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setMonthlyPoints(Map<String, Integer> monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
