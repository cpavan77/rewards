package com.charter.rewards.service;

import com.charter.rewards.dao.PurchaseTransactionRepository;
import com.charter.rewards.entity.PurchaseTransaction;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.charter.rewards.service.RewardsCalculator.calculate;
import static java.time.LocalDate.now;
import static java.time.Period.ofMonths;
import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * Service class that performs operations corresponding to customer rewards.
 *
 * @author Pavan Chakka
 * @since December 01, 2022.
 */
@Service
@RequiredArgsConstructor
public class CustomerRewardsService {

    final PurchaseTransactionRepository repository;

    public RewardsSummary getRewards(final Long customerId) {

        final LocalDate start = now().minus(ofMonths(3));
        final LocalDate end = now();
        final List<PurchaseTransaction> transactions = repository.findByCustomerIdAndTransactionDateRange(customerId, start, end);

        final RewardsSummary summary = new RewardsSummary();
        summary.setStartPeriod(start);
        summary.setEndPeriod(end);
        summary.setCustomerId(customerId);
        summary.setRewards(calculate(transactions));

        final var summaryTransactions = transactions.stream().map(transaction -> {
            return com.charter.rewards.service.PurchaseTransaction.builder()
                    .amount(transaction.getAmount())
                    .transactionDate(transaction.getTransactionDate())
                    .build();
        }).collect(Collectors.toList());
        summary.setTransactions(summaryTransactions);

        return summary;
    }
}
