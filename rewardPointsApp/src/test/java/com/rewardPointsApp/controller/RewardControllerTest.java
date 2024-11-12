package com.rewardPointsApp.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rewardPointsApp.Application.RewardPointsAppApplication;

@SpringBootTest(classes = RewardPointsAppApplication.class)
@AutoConfigureMockMvc
public class RewardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllCustomerRewards() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/rewards/all"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

     @Test
    public void testGetAllCustomersRewardReports() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/rewards/report"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    
    @Test
    public void testGetCustomerRewardReport() throws Exception {
        Long customerId = 1L; // Set a valid customer ID
        mockMvc.perform(MockMvcRequestBuilders.get("/api/rewards/" + customerId + "/report"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }
}
