package net.javaProjects.Banking.service;

import net.javaProjects.Banking.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto account);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id,double amount);
}
