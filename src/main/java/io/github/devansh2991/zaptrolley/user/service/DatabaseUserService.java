package io.github.devansh2991.zaptrolley.user.service;

import io.github.devansh2991.zaptrolley.user.dto.UserRequestDto;
import io.github.devansh2991.zaptrolley.user.model.User;
import io.github.devansh2991.zaptrolley.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public DatabaseUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long userId){
        return userRepository.findById(userId)
                .orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


}
