package com.tudu.todoapp.rest.controllers;

import com.tudu.todoapp.dto.UserAccountDto;
import com.tudu.todoapp.dto.mappers.UserAccountMapper;
import com.tudu.todoapp.entities.UserAccount;
import com.tudu.todoapp.services.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/accounts")
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final UserAccountMapper userAccountMapper;

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody UserAccountDto userAccountDto) {
        UserAccount createdAccount = userAccountService.createUserAccount(
            userAccountMapper.dtoToEntity(userAccountDto));

        return new ResponseEntity<>("api/v1/accounts/" + createdAccount.getAccountId(), HttpStatus.OK);
    }
}
