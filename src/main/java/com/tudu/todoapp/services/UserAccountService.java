package com.tudu.todoapp.services;

import com.tudu.todoapp.entities.UserAccount;
import com.tudu.todoapp.security.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAccountService {

    private static final UserAccount testAccount = UserAccount.builder()
        .accountId(1L)
        .email("email")
        .password("test")
        .role(Role.USER)
        .build();

    public UserAccount createUserAccount(UserAccount userAccount) {
        return testAccount; // account creation logic
    }
}
