package dev.zeyuchen.banking_app.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.zeyuchen.banking_app.dto.AccountDto;
import dev.zeyuchen.banking_app.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Tag(name = "Account Management", description = "Account management APIs")
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Operation(summary = "Create a new account",
            description = "Creates a new bank account with the provided details")
    @ApiResponse(responseCode = "201", description = "Account created successfully")
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody final AccountDto accountDto) {
        final AccountDto createdAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @Operation(summary = "Get account by ID", description = "Retrieves an account by its ID")
    @ApiResponse(responseCode = "200", description = "Account found successfully")
    @ApiResponse(responseCode = "404", description = "Account not found")
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable final Long id) {
        final AccountDto account = accountService.getAccountById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // Get all accounts REST API
    @Operation(summary = "Get all accounts", description = "Retrieves all accounts")
    @ApiResponse(responseCode = "200", description = "Accounts found successfully")
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        final List<AccountDto> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // Delete an account by id REST API
    @Operation(summary = "Delete an account by ID", description = "Deletes an account by its ID")
    @ApiResponse(responseCode = "204", description = "Account deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable final Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Update an account by id REST API
    @Operation(summary = "Update an account by ID", description = "Updates an account by its ID")
    @ApiResponse(responseCode = "200", description = "Account updated successfully")
    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable final Long id,
            @RequestBody final AccountDto accountDto) {
        final AccountDto updatedAccount = accountService.updateAccount(id, accountDto);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    // Deposit money into an account REST API
    @Operation(summary = "Deposit money into an account",
            description = "Deposits money into an account")
    @ApiResponse(responseCode = "200", description = "Money deposited successfully")
    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable final Long id,
            @RequestParam final double amount) {
        final AccountDto updatedAccount = accountService.deposit(id, amount);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    // Withdraw money from an account REST API
    @Operation(summary = "Withdraw money from an account",
            description = "Withdraws money from an account")
    @ApiResponse(responseCode = "200", description = "Money withdrawn successfully")
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable final Long id,
            @RequestParam final double amount) {
        final AccountDto updatedAccount = accountService.withdraw(id, amount);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }
}
