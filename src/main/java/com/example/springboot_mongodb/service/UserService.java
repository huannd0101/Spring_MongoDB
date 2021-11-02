package com.example.springboot_mongodb.service;

import com.example.springboot_mongodb.dto.UserDTO;
import com.example.springboot_mongodb.model.User;
import com.example.springboot_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createNewUser(UserDTO userDTO) {
        return userRepository.save(new User(null, userDTO.getUsername(), userDTO.getPassword()));
    }

    public User editUserByUsername(String username, UserDTO userDTO) {
        User user = getUserByUsername(username);
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    public User deleteUserByUsername(String username) {
        User user = getUserByUsername(username);
        userRepository.delete(user);
        return user;
    }

}
