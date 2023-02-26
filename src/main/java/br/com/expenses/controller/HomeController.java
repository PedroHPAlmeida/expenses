package br.com.expenses.controller;

import br.com.expenses.controller.dto.CurrentMonthDto;
import br.com.expenses.model.FinancialRecord;
import br.com.expenses.repository.FinancialRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/")
public class HomeController {

    private FinancialRecordRepository financialRecordRepository;

    @GetMapping
    public ModelAndView findAllFinancialRecords() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("financialRecords", financialRecordRepository.findAll());
        mv.addObject("currentMonthDto", new CurrentMonthDto());
        return mv;
    }

    @PostMapping(path = "/filter")
    public ModelAndView findFinancialRecordsByCurrentMonth(CurrentMonthDto curentMonthdMonthDto) {
        ModelAndView mv = new ModelAndView("home");
        List<FinancialRecord> financialRecords;
        if(curentMonthdMonthDto.getMonth().equals("all")) {
            financialRecords = financialRecordRepository.findAll();
        } else {
            financialRecords = financialRecordRepository.findByCurrentMonth(curentMonthdMonthDto.getMonth());
        }
        mv.addObject("financialRecords", financialRecords);
        return mv;
    }

}
