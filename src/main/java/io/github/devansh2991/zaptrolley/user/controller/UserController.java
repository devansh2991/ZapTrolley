package io.github.devansh2991.zaptrolley.user.controller;

import io.github.devansh2991.zaptrolley.user.dto.UserRequestDto;
import io.github.devansh2991.zaptrolley.user.model.User;
import io.github.devansh2991.zaptrolley.user.repositories.UserRepository;
import io.github.devansh2991.zaptrolley.user.service.DatabaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final DatabaseUserService databaseUserService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(DatabaseUserService databaseUserService, UserRepository userRepository) {
        this.databaseUserService = databaseUserService;
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User createdUser = databaseUserService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{userId}")
    public UserRequestDto getUser(@PathVariable Long userId) {
        return UserRequestDto.toDto(userRepository.findFirstByUserId(userId));
    }
}
