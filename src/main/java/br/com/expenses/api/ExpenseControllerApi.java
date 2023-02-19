package br.com.expenses.api;

import br.com.expenses.model.Expense;
import br.com.expenses.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/expenses")
public class ExpenseControllerApi {

    private ExpenseRepository repository;

    @GetMapping
    public List<Expense> findAll() {
        return repository.findAll();
    }

}
