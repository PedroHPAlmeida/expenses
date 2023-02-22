package br.com.expenses.controller;

import br.com.expenses.controller.dto.ExpenseDto;
import br.com.expenses.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/expenses")
public class ExpenseController {

    private ExpenseRepository expenseRepository;

    @GetMapping(path = "/form")
    public ModelAndView newExpense(ExpenseDto expense) {
        return new ModelAndView("new-expense");
    }

    @PostMapping(path = "/new")
    public ModelAndView save(ExpenseDto expense) {
        expenseRepository.save(expense.toExpense());
        return new ModelAndView("new-expense");
    }

}
