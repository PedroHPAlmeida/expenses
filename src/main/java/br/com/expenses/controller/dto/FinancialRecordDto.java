package br.com.expenses.controller.dto;

import br.com.expenses.model.FinancialRecord;
import br.com.expenses.model.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

@Getter @Setter
public class FinancialRecordDto {

    private String title;
    private BigDecimal amount;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private String description;
    private String currentMonth;
    private String transactionType;

    public FinancialRecord toFinancialRecord() {
        FinancialRecord financialRecord = new FinancialRecord();
        financialRecord.setTitle(this.title);
        financialRecord.setAmount(this.amount);
        financialRecord.setDate(this.date);
        financialRecord.setDescription(this.description);
        int monthNumber = Integer.parseInt(this.currentMonth.split("-")[1]);
        Month month = Month.of(monthNumber);
        String monthInPortuguese = month.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("pt", "BR"));
        financialRecord.setCurrentMonth(monthInPortuguese);
        financialRecord.setTransactionType(TransactionType.valueOf(this.transactionType.toUpperCase()));
        return financialRecord;
    }

}
