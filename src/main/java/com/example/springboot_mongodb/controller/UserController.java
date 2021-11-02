package com.example.springboot_mongodb.controller;

import com.example.springboot_mongodb.dto.UserDTO;
import com.example.springboot_mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String u) {
        return ResponseEntity.status(200).body(service.getUserByUsername(u));
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.status(200).body(service.getAllUser());
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewUser(userDTO));
    }

    @PatchMapping("/{username}")
    public ResponseEntity<?> editUserByUsername(@PathVariable("username") String u, @RequestBody UserDTO userDTO) {
        return ResponseEntity.status(200).body(service.editUserByUsername(u, userDTO));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUserByUsername(@PathVariable("username") String u) {
        return ResponseEntity.status(200).body(service.deleteUserByUsername(u));
    }

}
