package com.jmendoza.springbootcrudrest.controller;

import com.jmendoza.springbootcrudrest.exception.ResourceNotFoundException;
import com.jmendoza.springbootcrudrest.model.User;
import com.jmendoza.springbootcrudrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userService.getUsers();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "UserController");
        return ResponseEntity.ok().headers(headers).body(userList);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(
            @PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userService.getUser(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User userCreated = userService.createUser(user);
        return ResponseEntity.created(URI.create("/users/" + userCreated.getId())).body(userCreated);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") Long userId,
            @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userService.updateUser(userId, userDetails);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(
            @PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/name/{firstName}")
    public ResponseEntity<User> getUserByFirstName(
            @PathVariable(value = "firstName") String firstName) throws ResourceNotFoundException {
        User user = userService.getUserByFirstName(firstName);
        return ResponseEntity.ok().body(user);
    }
}
