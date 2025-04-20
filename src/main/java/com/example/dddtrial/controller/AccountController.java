package com.example.dddtrial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.dddtrial.form.AccountForm;
import com.example.dddtrial.service.AccountSenario;
import com.example.dddtrial.service.AccountService;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountSenario accountSenario;

    @GetMapping("/")
    public String showAccountDashBoard(Model model) {
        model.addAttribute("accounts", accountService.getAccountDetails()); // テーブル表示用
        model.addAttribute("accountForm", new AccountForm("", "", "")); // フォーム入力用
        return "index"; // index.html に対応
    }

    @PostMapping("/submitAccountForm")
    public String submitAccountForm(AccountForm accountForm, Model model) {
        List<AccountForm> accountForms = accountSenario.deposit(accountForm);
        model.addAttribute("accounts", accountForms);
        return "redirect:/";
    }
}
