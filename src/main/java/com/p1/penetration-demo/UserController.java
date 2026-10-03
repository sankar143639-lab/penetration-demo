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

    // 1. View all users (Browser URL: /api/users)
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // 2. Add user via browser GET request (Browser URL: /api/users/add?name=Alice&email=alice@example.com)
    @GetMapping("/add")
    public UserEntity createUserViaGet(@RequestParam String name, @RequestParam String email) {
        return userRepository.save(new UserEntity(name, email));
    }

    // 3. Standard REST POST method (For Postman / Frontend apps)
    @PostMapping
    public UserEntity createUser(@RequestParam String name, @RequestParam String email) {
        return userRepository.save(new UserEntity(name, email));
    }
}
