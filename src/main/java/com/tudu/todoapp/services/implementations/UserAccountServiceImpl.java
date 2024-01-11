package com.tudu.todoapp.services.implementations;

import com.tudu.todoapp.entities.UserAccount;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.repositories.UserAccountRepository;
import com.tudu.todoapp.security.Role;
import com.tudu.todoapp.services.interfaces.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    private static final UserAccount testAccount = UserAccount.builder()
        .accountId(1L)
        .email("email")
        .password("test")
        .role(Role.USER)
        .build();

    @Override
    public UserAccount getUserAccountById(Long userAccountId) throws ResourceNotFoundException {
        return repository.findById(userAccountId)
            .orElseThrow(() -> new ResourceNotFoundException("The user account was not found"));
    }

    @Override
    public UserAccount getUserAccountByEmail(String email) throws ResourceNotFoundException {
        return repository.findUserAccountByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException("The user account was not found"));
    }

    public UserAccount createUserAccount(UserAccount userAccount) {
        if (userAccount.getAccountId() != null && repository.existsById(userAccount.getAccountId())) {
            throw new ResourceConflictException("A user account with the same id already exists.");
        }
        return repository.save(userAccount);
    }

    @Override
    public UserAccount updatePassword(Long userAccountId, String newPassword) throws ResourceNotFoundException {
        UserAccount dbAccount = repository.findById(userAccountId)
            .orElseThrow(() -> new ResourceNotFoundException("The user account was not found"));
        dbAccount.setPassword(newPassword);
        return repository.save(dbAccount);
    }

    @Override
    public UserAccount updateEmail(String oldEmail, String newEmail) throws ResourceNotFoundException {
        UserAccount dbAccount = repository.findUserAccountByEmail(oldEmail)
            .orElseThrow(() -> new ResourceNotFoundException("The user account was not found"));
        dbAccount.setEmail(newEmail);
        return repository.save(dbAccount);
    }

    @Override
    public void deleteAllUserAccounts() {
        repository.deleteAll();
    }

    @Override
    public void deleteUserAccountById(Long userAccountId) throws ResourceNotFoundException {
        if (!repository.existsById(userAccountId)) {
            throw new ResourceNotFoundException("The user account was not found");
        }
        repository.deleteById(userAccountId);
    }
}
