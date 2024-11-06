package com.rewardPointsApp.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class TransactionTest {
    
    @Test
    public void testTransactionCreation() {
        Transaction transaction = new Transaction(1L, 1L, LocalDate.now(), 100.0);
        assertNotNull(transaction);
    }
}
