package com.charter.rewards.dao;

import com.charter.rewards.entity.PurchaseTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository class for customer purchase transactions.
 *
 * @author Pavan Chakka
 * @since November 30, 2022.
 */
public interface PurchaseTransactionRepository extends JpaRepository<PurchaseTransaction, Long> {

    @Query(value = "select * from purchase_transaction where customer_id = :customerId and transaction_date between :from and :to", nativeQuery = true)
    List<PurchaseTransaction> findByCustomerIdAndTransactionDateRange(@Param("customerId") Long customerId, @Param("from") LocalDate from, @Param("to") LocalDate to);
}
