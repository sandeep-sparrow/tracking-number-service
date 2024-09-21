package com.engineeringwithsandeep.learning.aop.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class AccountController {

    private final AccountDAOImpl accountDAO;

    public AccountController(AccountDAOImpl accountDAO) {
        this.accountDAO = accountDAO;
    }

    @PostMapping("/accounts")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        accountDAO.addAccount(account, true);
        return ResponseEntity.status(HttpStatus.CREATED).body("Account with name: " + account.accountName + " created");
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> findAccounts() {
        List<Account> accounts = accountDAO.findAccounts(false);
        return ResponseEntity.status(HttpStatus.CREATED).body(accounts);
    }

    @GetMapping("/accounts/{tripWire}")
    public void demoAfterThrowingAdvice(@PathVariable boolean tripWire) {
        List<Account> accounts = null;
        try {
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception ex) {
            log.error("\n\n Main program: ... caught exception: {}", ex.getMessage());
        }
    }
}