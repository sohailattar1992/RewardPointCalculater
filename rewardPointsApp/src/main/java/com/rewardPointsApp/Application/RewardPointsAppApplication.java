package com.rewardPointsApp.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.rewardPointsApp",exclude = { DataSourceAutoConfiguration.class })
public class RewardPointsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardPointsAppApplication.class, args);
	}

}
