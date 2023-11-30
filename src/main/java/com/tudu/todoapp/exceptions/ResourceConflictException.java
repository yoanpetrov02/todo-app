package com.tudu.todoapp.exceptions;

/**
 * Thrown whenever there is a conflict between existing resource data and one that is passed by the user.
 * Usually indicates that a 409 Conflict response should be returned.
 */
public class ResourceConflictException extends RuntimeException {

    public ResourceConflictException(String message) {
        super(message);
    }
}
