package com.charter.rewards.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity representing customer's purchase transaction.
 *
 * @author Pavan Chakka
 * @since November 30, 2022.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PURCHASE_TRANSACTION")
public class PurchaseTransaction {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "purchase_transaction_seq_gen")
    @SequenceGenerator(name = "purchase_transaction_id_seq", sequenceName = "purchase_transaction_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "customer_id")
    private Long customerId;
}
