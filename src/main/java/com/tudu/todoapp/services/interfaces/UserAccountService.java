package com.tudu.todoapp.services.interfaces;

import com.tudu.todoapp.entities.UserAccount;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;

public interface UserAccountService {

    /**
     * Returns the user account with that id.
     *
     * @throws ResourceNotFoundException if the user account was not found.
     */
    UserAccount getUserAccountById(Long userAccountId) throws ResourceNotFoundException;

    /**
     * Returns the user account with that email.
     *
     * @throws ResourceNotFoundException if the user account was not found.
     */
    UserAccount getUserAccountByEmail(String email) throws ResourceNotFoundException;

    /**
     * Creates the new user account in the database.
     *
     * @param userAccount the user account's information.
     * @return the saved {@code UserAccount}.
     * @throws ResourceConflictException if a user account with the same id already exists.
     */
    UserAccount createUserAccount(UserAccount userAccount) throws ResourceConflictException;

    /**
     * Updates the password of the given account to the new password.
     *
     * @param userAccountId the id of the user account.
     * @param newPassword the new password of the account.
     * @return the updated {@code UserAccount}.
     * @throws ResourceNotFoundException if the account was not found.
     */
    UserAccount updatePassword(Long userAccountId, String newPassword) throws ResourceNotFoundException;

    /**
     * Updates the email of the given account to the new email.
     *
     * @param userAccountId the id of the user account.
     * @param newEmail the new email of the account.
     * @return the updated {@code UserAccount}.
     * @throws ResourceNotFoundException if the account was not found.
     */
    UserAccount updateEmail(Long userAccountId, String newEmail) throws ResourceNotFoundException;

    /**
     * Deletes all user accounts from the database.
     */
    void deleteAllUserAccounts();

    /**
     * Deletes the user account with the given id.
     *
     * @param userAccountId the id of the user account.
     */
    void deleteUserAccountById(Long userAccountId) throws ResourceNotFoundException;
}
