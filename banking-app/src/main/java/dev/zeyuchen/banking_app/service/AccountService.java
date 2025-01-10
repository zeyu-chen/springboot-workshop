package dev.zeyuchen.banking_app.service;

import java.util.List;
import dev.zeyuchen.banking_app.dto.AccountDto;

public interface AccountService {
    // Create an account
    AccountDto createAccount(AccountDto accountDto);

    // Get an account by id
    AccountDto getAccountById(Long id);

    // Get all accounts
    List<AccountDto> getAllAccounts();

    // Delete an account by id
    void deleteAccount(Long id);

    // Update an account by id
    AccountDto updateAccount(Long id, AccountDto accountDto);

    // Deposit money into an account
    AccountDto deposit(Long id, double amount);

    // Withdraw money from an account
    AccountDto withdraw(Long id, double amount);
}
