package com.charter.rewards.service;

import com.charter.rewards.entity.PurchaseTransaction;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.math.RoundingMode.HALF_UP;

/**
 * Calculates customer rewards.
 *
 * @author Pavan Chakka
 * @since December 02, 2022.
 */
public class RewardsCalculator {

    public static int calculate(final List<PurchaseTransaction> transactions) {

        final AtomicInteger rewards = new AtomicInteger();

        transactions.forEach(transaction -> {
            final int amount = transaction.getAmount().setScale(0, HALF_UP).intValue();
            if (amount > 100) {
                rewards.set(rewards.get() + 50 + (amount - 100) * 2);
            } else if (amount > 50) {
                rewards.set(rewards.get() + amount - 50);
            }
        });

        return rewards.get();
    }
}
