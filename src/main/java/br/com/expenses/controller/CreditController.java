package br.com.expenses.controller;

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

    @GetMapping(path = "/form")
    public ModelAndView newCredit() {
        return new ModelAndView("new-credit");
    }

    @PostMapping(path = "/new")
    public ModelAndView save() {
        return new ModelAndView("new-credit");
    }

}
