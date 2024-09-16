package com.hrms.account.service;

import com.hrms.account.repository.AccountRepository;
import com.hrms.common.domain.entity.Account;
import com.hrms.common.enums.Role;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Resource
    private AccountRepository accountRepository;

    public List<?> getAccountList() {
        List<Account> list = accountRepository.findAll();
        System.out.println(Role.description(Role.ADMIN));
        return list;
    }

    public void deleteAccount(long id) {
        accountRepository.deleteById(id);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
