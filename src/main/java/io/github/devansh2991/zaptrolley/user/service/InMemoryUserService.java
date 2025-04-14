package io.github.devansh2991.zaptrolley.user.service;

import io.github.devansh2991.zaptrolley.user.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryUserService implements UserService {

    private final List<User> users;

    public InMemoryUserService(List<User> users) {
        this.users = new ArrayList<>();
    }

    @Override
    public User getUserById(Long userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null; // or throw exception if not found
    }

    @Override
    public User createUser(User user) {
         users.add(user);
         return user;
    }
}
