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
public class UserService {

    private final UserRepository userRepository;

    /**
     * Returns all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Returns the page with the amount of users per page, or as many as there are on that page in the database.
     *
     * @param pageNumber the number of the page.
     *                   This value gets converted to an index by subtracting 1 from it,
     *                   so don't modify the value before passing it to this method.
     * @param perPage the amount of users on each page.
     * @return the page as a {@code List}.
     */
    public List<User> getUsers(int pageNumber, int perPage) {
        int pageIndex = pageNumber - 1;
        Pageable page = PageRequest.of(pageIndex, perPage);
        return userRepository.findAll(page).toList();
    }

    /**
     * Returns a user by its id.
     *
     * @throws ResourceNotFoundException if the user was not found.
     */
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("The user with the specified id was not found."));
    }

    /**
     * Creates the new user in the database.
     *
     * @param user the user's information.
     * @return the saved {@code User}.
     * @throws ResourceConflictException if a user with the same id already exists.
     */
    public User createUser(User user) {
        if (user.getUserId() != null && userRepository.existsById(user.getUserId())) {
            throw new ResourceConflictException("A user with the same id already exists.");
        }
        return userRepository.save(user);
    }

    /**
     * Updates the user with the given id with the new data.
     *
     * @param userId the id of the user.
     * @param newData the new data of the user.
     * @return the updated {@code User}.
     * @throws ResourceNotFoundException if the user was not found
     * @throws ResourceConflictException if another user already has the new username of the user.
     */
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

    /**
     * Deletes all users from the database.
     */
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    /**
     * Deletes the user with the given id.
     *
     * @throws ResourceNotFoundException if the user was not found.
     */
    public void deleteUserById(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("The user with the specified id was not found.");
        }
        userRepository.deleteById(userId);
    }

    public Optional<User> findUserByDisplayName(String displayName) {
        return userRepository.findUserByDisplayName(displayName);
    }
}
