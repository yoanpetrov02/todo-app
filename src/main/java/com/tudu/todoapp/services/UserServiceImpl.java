package com.tudu.todoapp.services;

import com.tudu.todoapp.entities.User;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A service with business logic regarding users.
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersPage(int pageNumber, int perPage) {
        int pageIndex = pageNumber - 1;
        Pageable page = PageRequest.of(pageIndex, perPage);
        return userRepository.findAll(page).toList();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("The user with the specified id was not found."));
    }

    public User getUserByUsername(String displayName) {
        return userRepository.findUserByDisplayName(displayName)
            .orElseThrow(() ->
                new ResourceNotFoundException("The user with the specified display name was not found."));
    }

    public User createUser(User user) {
        if (user.getUserId() != null && userRepository.existsById(user.getUserId())) {
            throw new ResourceConflictException("A user with the same id already exists.");
        }
        return userRepository.save(user);
    }


    public User updateUser(Long userId, User newData) {
        try {
            User dbUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("The user with the specified id was not found."));
            dbUser.setDisplayName(newData.getDisplayName());
            return userRepository.save(dbUser);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceConflictException("A user with that username already exists.");
        }
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public void deleteUserById(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("The user with the specified id was not found.");
        }
        userRepository.deleteById(userId);
    }
}
