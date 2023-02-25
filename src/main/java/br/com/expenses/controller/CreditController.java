package br.com.expenses.controller;

import br.com.expenses.controller.dto.FinancialRecordDto;
import br.com.expenses.model.FinancialRecord;
import br.com.expenses.repository.FinancialRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping(path = "credits")
public class CreditController {

    private FinancialRecordRepository financialRecordRepository;

    @GetMapping(path = "/form")
    public ModelAndView newCredit(FinancialRecordDto financialRecordDto) {
        return new ModelAndView("new-credit");
    }

    @PostMapping(path = "/new")
    public ModelAndView save(FinancialRecordDto financialRecordDto) {
        financialRecordRepository.save(financialRecordDto.toFinancialRecord());
        return new ModelAndView("new-credit");
    }

}
