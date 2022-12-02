package com.charter.rewards.service;

import com.charter.rewards.entity.PurchaseTransaction;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.math.BigDecimal.valueOf;

class RewardsCalculatorTest {

    @Test
    public final void testCalculate() {

        val transactions = new ArrayList<PurchaseTransaction>();

        final PurchaseTransaction transaction1 = new PurchaseTransaction();
        transaction1.setAmount(valueOf(175.20));
        transactions.add(transaction1);

        final PurchaseTransaction transaction2 = new PurchaseTransaction();
        transaction2.setAmount(valueOf(80.97));
        transactions.add(transaction2);

        final PurchaseTransaction transaction3 = new PurchaseTransaction();
        transaction3.setAmount(valueOf(50.25));
        transactions.add(transaction3);

        final PurchaseTransaction transaction4 = new PurchaseTransaction();
        transaction4.setAmount(valueOf(45));
        transactions.add(transaction4);

        final PurchaseTransaction transaction5 = new PurchaseTransaction();
        transaction5.setAmount(valueOf(38));
        transactions.add(transaction5);

        final PurchaseTransaction transaction6 = new PurchaseTransaction();
        transaction6.setAmount(valueOf(79));
        transactions.add(transaction6);

        final PurchaseTransaction transaction7 = new PurchaseTransaction();
        transaction7.setAmount(valueOf(170));
        transactions.add(transaction7);

        final PurchaseTransaction transaction8 = new PurchaseTransaction();
        transaction8.setAmount(valueOf(122));
        transactions.add(transaction8);

        final int rewards = RewardsCalculator.calculate(transactions);
        Assertions.assertEquals(544, rewards);
    }
}