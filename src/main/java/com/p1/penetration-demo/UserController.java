package com.p1.penetrationdemo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/add")
    public UserEntity createUserViaGet(@RequestParam String name, @RequestParam String email) {
        return userRepository.save(new UserEntity(name, email));
    }

    @PostMapping
    public UserEntity createUser(@RequestParam String name, @RequestParam String email) {
        return userRepository.save(new UserEntity(name, email));
    }
}
