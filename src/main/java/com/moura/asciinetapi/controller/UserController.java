package com.moura.asciinetapi.controller;


import com.moura.asciinetapi.dto.UserDto;
import com.moura.asciinetapi.entity.User;
import com.moura.asciinetapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<User> userList = userService.getUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<User> optionalUser = userService.getById(id);
        return new ResponseEntity<>(optionalUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        User userWithId = userService.save(user);
        return new ResponseEntity<>(userWithId, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user) {
        User updatedUser = userService.save(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(@RequestBody Long id) {
        userService.deleteById(id);
        boolean deleted = userService.getById(id).isPresent();

        return new ResponseEntity<>(!deleted, HttpStatus.OK);
    }
}