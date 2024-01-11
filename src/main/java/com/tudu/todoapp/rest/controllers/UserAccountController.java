package com.tudu.todoapp.rest.controllers;

import com.tudu.todoapp.dto.UserAccountDto;
import com.tudu.todoapp.dto.mappers.UserAccountMapper;
import com.tudu.todoapp.entities.UserAccount;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.services.implementations.UserAccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/accounts")
public class UserAccountController {

    private final UserAccountServiceImpl userAccountService;
    private final UserAccountMapper userAccountMapper;

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody UserAccountDto userAccountDto) {
        UserAccount createdAccount = userAccountService.createUserAccount(
            userAccountMapper.dtoToEntity(userAccountDto));

        return new ResponseEntity<>("api/v1/accounts/" + createdAccount.getAccountId(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserAccountById(@PathVariable Long id) {
        try {
            UserAccount userAccount = userAccountService.getUserAccountById(id);
            return new ResponseEntity<>(userAccount, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUserAccountById(@PathVariable String email) {
        try {
            UserAccount userAccount = userAccountService.getUserAccountByEmail(email);
            return new ResponseEntity<>(userAccount, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/changeEmail")
    public ResponseEntity<?> updateEmail(
        @RequestParam(defaultValue = "unknown") String email,
        @RequestParam(defaultValue = "unknown") String newEmail
    ) {
        if ("unknown".equals(email)) {
            return new ResponseEntity<>(
                "Please, provide a value for the current email.", HttpStatus.BAD_REQUEST);
        }
        if ("unknown".equals(newEmail)) {
            return new ResponseEntity<>(
                "No new email provided, nothing has changed.", HttpStatus.OK);
        }
        try {
            UserAccount updated = userAccountService.updateEmail(email, newEmail);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/changePassword/{id}")
    public ResponseEntity<?> updatePassword(
        @PathVariable Long id,
        @RequestParam String newPassword
    ) {
        if (newPassword == null) {
            return new ResponseEntity<>("Please, provide a new password", HttpStatus.BAD_REQUEST);
        }
        try {
            UserAccount updated = userAccountService.updatePassword(id, newPassword);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
