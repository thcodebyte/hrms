package com.hrms.web.controller;

import com.hrms.account.service.AccountService;
import com.hrms.common.domain.entity.Account;
import com.hrms.common.result.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping
    public R<?> createAccount() {
        return R.created();
    }

    @GetMapping
    public R<?> getAccounts() {
        List<Account> accounts = accountService.getAccounts();
        return R.ok(accounts);
    }
}
