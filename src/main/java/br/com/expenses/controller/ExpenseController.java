package br.com.expenses.controller;

import br.com.expenses.model.Expense;
import br.com.expenses.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/expenses")
public class ExpenseController {

    private ExpenseRepository expenseRepository;

    @GetMapping(path = "/form")
    public ModelAndView newExpense(Expense expense) {
        System.out.println(expense);
        return new ModelAndView("new-expense");
    }

    @PostMapping(path = "new")
    public ModelAndView save(Expense expense) {
        System.out.println(expense);
        expenseRepository.save(expense);
        return new ModelAndView("new-expense");
    }

    @GetMapping(path = "/list")
    private List<Expense> list() {
        return expenseRepository.findAll();
    }

}
