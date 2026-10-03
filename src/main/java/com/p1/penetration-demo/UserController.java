package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users from PostgreSQL
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Add a new user to PostgreSQL
    @PostMapping
    public UserEntity createUser(@RequestParam String name, @RequestParam String email) {
        return userRepository.save(new UserEntity(name, email));
    }
}
