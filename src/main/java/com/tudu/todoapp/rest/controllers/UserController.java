package com.tudu.todoapp.rest.controllers;

import com.tudu.todoapp.entities.User;
import com.tudu.todoapp.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);

        return new ResponseEntity<>("created yea", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newData) {
        return new ResponseEntity<>(userService.updateUser(id, newData), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllUsers() {
        userService.deleteAllUsers();

        return new ResponseEntity<>("All users have been successfully deleted", HttpStatus.OK);
    }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        userService.deleteUserById(id);

        return new ResponseEntity<>("User has been successfully deleted", HttpStatus.OK);
   }
}
