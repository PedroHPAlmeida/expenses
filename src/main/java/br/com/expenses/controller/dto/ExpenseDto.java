package br.com.expenses.controller.dto;

import br.com.expenses.model.Expense;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

@Getter @Setter
public class ExpenseDto {

    private String title;
    private BigDecimal amount;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private String description;
    private String currentMonth;

    public Expense toExpense() {
        Expense expense = new Expense();
        expense.setTitle(this.title);
        expense.setAmount(this.amount);
        expense.setDate(this.date);
        expense.setDescription(this.description);
        int monthNumber = Integer.parseInt(this.currentMonth.split("-")[1]);
        Month month = Month.of(monthNumber);
        String monthInPortuguese = month.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("pt", "BR"));
        expense.setCurrentMonth(monthInPortuguese);
        return expense;
    }

}
