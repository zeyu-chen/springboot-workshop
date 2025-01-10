package dev.zeyuchen.banking_app.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import dev.zeyuchen.banking_app.dto.AccountDto;
import dev.zeyuchen.banking_app.entity.Account;
import dev.zeyuchen.banking_app.exception.InsufficientFundsException;
import dev.zeyuchen.banking_app.exception.ResourceNotFoundException;
import dev.zeyuchen.banking_app.mapper.AccountMapper;
import dev.zeyuchen.banking_app.repository.AccountRepository;
import dev.zeyuchen.banking_app.service.AccountService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper = AccountMapper.INSTANCE;

    // Create an account
    @Override
    public AccountDto createAccount(final AccountDto accountDto) {
        final Account account = accountMapper.toEntity(accountDto);
        final Account savedAccount = accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

    // Get an account by id
    @Override
    public AccountDto getAccountById(final Long id) {
        final Account account = accountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Account not found with id: " + id));
        return accountMapper.toDto(account);
    }

    // Get all accounts
    @Override
    public List<AccountDto> getAllAccounts() {
        final List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(accountMapper::toDto).collect(Collectors.toList());
    }

    // Delete an account by id
    @Override
    public void deleteAccount(final Long id) {
        accountRepository.deleteById(id);
    }

    // Update an account by id
    @Override
    public AccountDto updateAccount(final Long id, final AccountDto accountDto) {
        final Account existingAccount = accountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Account not found with id: " + id));

        // Create new Account entity with updated values
        final Account updatedAccount = new Account(existingAccount.getId(),
                accountDto.accountHolderName(), accountDto.balance());

        return accountMapper.toDto(accountRepository.save(updatedAccount));
    }

    // Deposit money into an account
    @Override
    public AccountDto deposit(final Long id, final double amount) {
        final Account account = accountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Account not found with id: " + id));

        account.setBalance(account.getBalance() + amount);
        return accountMapper.toDto(accountRepository.save(account));
    }

    // Withdraw money from an account
    @Override
    public AccountDto withdraw(final Long id, final double amount) {
        final Account account = accountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Account not found with id: " + id));

        if (account.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds in the account");
        }

        account.setBalance(account.getBalance() - amount);
        return accountMapper.toDto(accountRepository.save(account));
    }
}
