package com.tudu.todoapp.services;

import com.tudu.todoapp.entities.UserAccount;
import com.tudu.todoapp.repositories.UserAccountRepository;
import com.tudu.todoapp.security.Role;
import com.tudu.todoapp.services.interfaces.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    private static final UserAccount testAccount = UserAccount.builder()
        .accountId(1L)
        .email("email")
        .password("test")
        .role(Role.USER)
        .build();

    public UserAccount createUserAccount(UserAccount userAccount) {
        return testAccount; // account creation logic
    }

    public Optional<UserAccount> findUserAccountByEmail(String email) {
        return userAccountRepository.findUserAccountByEmail(email);
    }
}
