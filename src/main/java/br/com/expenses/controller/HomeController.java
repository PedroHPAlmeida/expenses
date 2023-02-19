package br.com.expenses.controller;

import br.com.expenses.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/")
public class HomeController {

    private ExpenseRepository expenseRepository;

    @GetMapping
    public ModelAndView findAllExpenses() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("expenses", expenseRepository.findAll());
        return mv;
    }

}
