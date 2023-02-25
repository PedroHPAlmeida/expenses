package br.com.expenses.controller;

import br.com.expenses.repository.FinancialRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/")
public class HomeController {

    private FinancialRecordRepository financialRecordRepository;

    @GetMapping
    public ModelAndView findAllExpenses() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("financialRecords", financialRecordRepository.findAll());
        return mv;
    }

}
