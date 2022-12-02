package com.charter.rewards.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RewardsSummary {

    private int rewards;
    private LocalDate startPeriod;
    private LocalDate endPeriod;
    private Long customerId;

    private List<PurchaseTransaction> transactions;
}
