package io.github.devansh2991.zaptrolley.user.controller;

import io.github.devansh2991.zaptrolley.user.dto.UserRequestDto;
import io.github.devansh2991.zaptrolley.user.model.User;
import io.github.devansh2991.zaptrolley.user.service.DatabaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final DatabaseUserService databaseUserService;

    @Autowired
    public UserController(DatabaseUserService databaseUserService) {
        this.databaseUserService = databaseUserService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User createdUser = databaseUserService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User user = databaseUserService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}
