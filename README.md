# Reward Points Application

The Reward Points Application is a Spring Boot REST API that calculates and provides reward points for customers based on their transactions. 
The API includes endpoints to retrieve reward points for individual customers, all customers, and detailed reward reports.

# Table of Contents

Project Overview.
-Technologies Used.
-Project Structure.
-API Endpoints.
-Get Customer Rewards.
-Get All Customer Rewards.
-Get Customer Reward Report.
-Get All Customers Reward Reports.
-Setting Up and Running the Project.
-License.

# Project Overview

This application is designed to simulate a rewards system where customers earn points based on their purchase transactions. Points are awarded as follows:

50 Points for every transaction over $50.
1 Point for every dollar spent between $50 and $100.
2 Points for every dollar spent over $100.
Customers can view their monthly rewards, and administrators can retrieve reward reports for all customers.

# Technologies Used

Java (Java 11 or later)
Spring Boot (2.7.13)
Maven for build management
Database :  For now not implemented, In future can integrate Spring Data JPA (Optional if database integration is needed).
H2 or any relational database (for persistent data storage).

# Project Structure

src
└── main
    ├── java
    │   └── com
    │       └── rewardPointsApp
    │           ├── controller         # REST controllers
    │           │   └── RewardController.java
    │           ├── service            # Business logic services
    │           │   └── RewardService.java
    │           ├── model              # Data models
    │           │   ├── RewardReport.java
    │           │   └── Transaction.java
    │           └── Application        # Application entry point
    │               └── RewardPointsApplication.java
    └── resources
        └── application.properties
└── test
    └── java
        └── com
            └── rewardPointsApp
                ├── controller
                │   └── RewardControllerTest.java
                └── Application
                    └── RewardPointsAppApplicationTests.java



# API Endpoints

1. Get Customer Rewards
URL: /api/rewards/{customerId}
Method: GET
Description: Retrieves reward points for a specific customer, grouped by month.

Response Example:

{
    "AUGUST": 130,
    "SEPTEMBER": 70
}



2. Get All Customer Rewards
URL: /api/rewards/all
Method: GET
Description: Retrieves reward points for all customers.

Response Example:

{
    "1": {
        "September": 70,
        "August": 90
    },
    "2": {
        "September": 130,
        "August": 40
    }
}



3. Get Customer Reward Report
URL: /api/rewards/{customerId}/report
Method: GET
Description: Retrieves a detailed reward report for a specific customer.

Response Example:

{
    "customerId": 1,
    "monthlyPoints": {
        "AUGUST": 130,
        "SEPTEMBER": 70
    },
    "totalPoints": 200,
    "transactions": [
        {
            "id": 1,
            "customerId": 1,
            "transactionDate": "2024-08-10",
            "amount": 120.0
        },
        {
            "id": 2,
            "customerId": 1,
            "transactionDate": "2024-08-15",
            "amount": 90.0
        },
        {
            "id": 3,
            "customerId": 1,
            "transactionDate": "2024-09-05",
            "amount": 110.0
        }
    ]
}


4. Get All Customers Reward Reports
URL: /api/rewards/report
Method: GET
Description: Retrieves detailed reward reports for all customers.

Response Example:

[
    {
        "customerId": 1,
        "monthlyPoints": {
            "AUGUST": 130,
            "SEPTEMBER": 70
        },
        "totalPoints": 200,
        "transactions": [
            {
                "id": 1,
                "customerId": 1,
                "transactionDate": "2024-08-10",
                "amount": 120.0
            },
            {
                "id": 2,
                "customerId": 1,
                "transactionDate": "2024-08-15",
                "amount": 90.0
            },
            {
                "id": 3,
                "customerId": 1,
                "transactionDate": "2024-09-05",
                "amount": 110.0
            }
        ]
    },
    {
        "customerId": 2,
        "monthlyPoints": {
            "AUGUST": 130,
            "SEPTEMBER": 70
        },
        "totalPoints": 200,
        "transactions": [
            {
                "id": 1,
                "customerId": 2,
                "transactionDate": "2024-08-10",
                "amount": 120.0
            },
            {
                "id": 2,
                "customerId": 2,
                "transactionDate": "2024-08-15",
                "amount": 90.0
            },
            {
                "id": 3,
                "customerId": 2,
                "transactionDate": "2024-09-05",
                "amount": 110.0
            }
        ]
    },
    {
        "customerId": 3,
        "monthlyPoints": {
            "AUGUST": 130,
            "SEPTEMBER": 70
        },
        "totalPoints": 200,
        "transactions": [
            {
                "id": 1,
                "customerId": 3,
                "transactionDate": "2024-08-10",
                "amount": 120.0
            },
            {
                "id": 2,
                "customerId": 3,
                "transactionDate": "2024-08-15",
                "amount": 90.0
            },
            {
                "id": 3,
                "customerId": 3,
                "transactionDate": "2024-09-05",
                "amount": 110.0
            }
        ]
    }
]



# Setting Up and Running the Project
# Prerequisites
Ensure Java 11 (or later) and Maven are installed on your system.

# Steps

1) Clone the Repository:

git clone https://github.com/sohailattar1992/RewardPointCalculater.git
cd RewardPointCalculater

2) Build the Project:

mvn clean install

3) Run the Application:

mvn spring-boot:run

Alternate on Eclipse/STS tool - Right click on main file Click on -> Run As -> Springboot App.

Alternatively, you can run the JAR file:

java -jar target/rewardPointsApp-0.0.1-SNAPSHOT.jar


# Configuration

Edit src/main/resources/application.properties if needed to configure the database or other settings.

Example properties for H2:

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update


# License

This project is licensed under the MIT License.



















