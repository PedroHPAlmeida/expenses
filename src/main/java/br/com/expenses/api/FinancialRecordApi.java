package br.com.expenses.api;

import br.com.expenses.model.FinancialRecord;
import br.com.expenses.model.TransactionType;
import br.com.expenses.repository.FinancialRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/financial-records")
public class FinancialRecordApi {

    private FinancialRecordRepository financialRecordRepository;

    @GetMapping
    public List<FinancialRecord> findAll() {
        return financialRecordRepository.findAll();
    }

    @GetMapping(path = "/filter")
    public List<FinancialRecord> findByTransactionType(@RequestParam(value = "transactionType") String transactionType) {
        TransactionType transaction = TransactionType.valueOf(transactionType.toUpperCase());
        return financialRecordRepository.findByTransactionType(transaction);
    }

}
