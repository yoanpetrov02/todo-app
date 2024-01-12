package com.tudu.todoapp.rest.controllers;

import com.tudu.todoapp.dto.UserDto;
import com.tudu.todoapp.dto.mappers.UserMapper;
import com.tudu.todoapp.entities.User;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<?> getUsers(
        @RequestParam(defaultValue = "1") Integer pageNumber,
        @RequestParam(defaultValue = "10") Integer itemsPerPage
    ) {
        List<User> users = userService.getUsersPage(pageNumber, itemsPerPage);
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        try {
            User user = userService.getUserByDisplayName(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto createdUser) {
        User user = userMapper.dtoToEntity(createdUser);
        try {
            userService.createUser(user);
            return new ResponseEntity<>("created yea", HttpStatus.OK);
        } catch (ResourceConflictException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDto newData) {
        User newUserData = userMapper.dtoToEntity(newData);
        try {
            return new ResponseEntity<>(userService.updateUser(id, newUserData), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (ResourceConflictException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllUsers() {
        userService.deleteAllUsers();
        return new ResponseEntity<>("All users have been deleted", HttpStatus.OK);
    }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        userService.deleteUserById(id);
        return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
   }
}
