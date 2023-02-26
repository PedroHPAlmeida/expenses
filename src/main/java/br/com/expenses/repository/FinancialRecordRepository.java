package br.com.expenses.repository;

import br.com.expenses.model.FinancialRecord;
import br.com.expenses.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
    List<FinancialRecord> findByTransactionType(TransactionType transaction);
}
