package com.charter.rewards.controller;

import com.charter.rewards.service.CustomerRewardsService;
import com.charter.rewards.service.RewardsSummary;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller corresponding to customer's purchase transactions.
 *
 * @author Pavan Chakka
 * @since November 30, 2022.
 */
@RestController
@AllArgsConstructor
public class CustomerRewardsController {

    final CustomerRewardsService rewardsService;

    @GetMapping("/customer-rewards/{customerId}")
    public RewardsSummary getCustomerRewards(@PathVariable Long customerId) {

        return rewardsService.getRewards(customerId);
    }
}