package com.rewardPointsApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rewardPointsApp.model.Transaction;

public class RewardServiceTest {
    
    private RewardService rewardService;
    
    @BeforeEach
    public void setup() {
        rewardService = new RewardService();
    }
    
    @Test
    public void testCalculateMonthlyPoints() {
        List<Transaction> transactions = List.of(
            new Transaction(1L, 1L, LocalDate.of(2024, 8, 10), 120.0),
            new Transaction(2L, 1L, LocalDate.of(2024, 8, 15), 90.0),
            new Transaction(3L, 1L, LocalDate.of(2024, 9, 5), 110.0)
        );
        
        Map<String, Integer> monthlyPoints = rewardService.calculateMonthlyPoints(transactions);
        
        assertEquals(130, monthlyPoints.get("AUGUST"));
        assertEquals(70, monthlyPoints.get("SEPTEMBER"));
    }
}



