package com.tudu.todoapp.services.interfaces;

import com.tudu.todoapp.entities.User;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;

import java.util.List;

/**
 * Business logic related to {@code User} entities.
 */
public interface UserService {

    /**
     * Returns all users.
     */
    List<User> getAllUsers();

    /**
     * Returns the page with the amount of users per page, or as many as there are on that page in the database.
     *
     * @param pageNumber the number of the page.
     *                   This value gets converted to an index by subtracting 1 from it,
     *                   so don't modify the value before passing it to this method.
     * @param perPage the amount of users on each page.
     * @return the page as a {@code List}.
     */
    List<User> getUsersPage(int pageNumber, int perPage);

    /**
     * Returns the user with that id.
     *
     * @throws ResourceNotFoundException if the user was not found.
     */
    User getUserById(Long userId) throws ResourceNotFoundException;

    /**
     * Returns the user with that display name.
     *
     * @throws ResourceNotFoundException if the user was not found.
     */
    User getUserByDisplayName(String displayName) throws ResourceNotFoundException;

    /**
     * Creates the new user in the database.
     *
     * @param user the user's information.
     * @return the saved {@code User}.
     * @throws ResourceConflictException if a user with the same id already exists.
     */
    User createUser(User user) throws ResourceConflictException;

    /**
     * Updates the user with the given id with the new data.
     *
     * @param userId the id of the user.
     * @param newData the new data of the user.
     * @return the updated {@code User}.
     * @throws ResourceNotFoundException if the user was not found.
     * @throws ResourceConflictException if another user already has the new username of the user.
     */
    User updateUser(Long userId, User newData) throws ResourceNotFoundException, ResourceConflictException;

    /**
     * Deletes all users from the database.
     */
    void deleteAllUsers();

    /**
     * Deletes the user with the given id.
     *
     * @param userId the id of the user.
     */
    void deleteUserById(Long userId) throws ResourceNotFoundException;
}
