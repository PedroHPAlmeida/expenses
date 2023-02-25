package br.com.expenses.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class FinancialRecord {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal amount;
    private LocalDate date;
    private String currentMonth;
    private String description;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

}
