package br.com.expenses.api;

import br.com.expenses.model.FinancialRecord;
import br.com.expenses.repository.FinancialRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
