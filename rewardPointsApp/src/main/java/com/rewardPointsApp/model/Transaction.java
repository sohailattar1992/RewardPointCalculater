package com.rewardPointsApp.model;

import java.time.LocalDate;

public class Transaction {

	 private Long id;
	    private Long customerId;
	    private LocalDate transactionDate;
	    private Double amount;
	    
		public Transaction(Long id, Long customerId, LocalDate transactionDate, Double amount) {
			super();
			this.id = id;
			this.customerId = customerId;
			this.transactionDate = transactionDate;
			this.amount = amount;
		}
		
		

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
		public LocalDate getTransactionDate() {
			return transactionDate;
		}
		public void setTransactionDate(LocalDate transactionDate) {
			this.transactionDate = transactionDate;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}	
	    
		@Override
		public String toString() {
			return "Transaction [id=" + id + ", customerId=" + customerId + ", transactionDate=" + transactionDate
					+ ", amount=" + amount + "]";
		} 
	
}
