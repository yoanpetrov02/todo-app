package com.tudu.todoapp.exceptions;

/**
 * Thrown whenever a resource was not found on the server.
 * Usually indicates that a 404 Not Found response should be returned.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
