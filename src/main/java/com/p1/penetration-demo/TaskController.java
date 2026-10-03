package com.example.demo;

import jakarta.validation.Valid;
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

    @PostMapping
    public UserEntity createUser(@Valid @RequestBody UserRequestDTO dto) {
        UserEntity user = new UserEntity(dto.getName(), dto.getEmail());
        return userRepository.save(user);
    }
}
