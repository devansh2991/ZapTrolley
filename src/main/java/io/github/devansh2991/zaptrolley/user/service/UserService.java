package io.github.devansh2991.zaptrolley.user.service;

import io.github.devansh2991.zaptrolley.user.dto.UserRequestDto;
import io.github.devansh2991.zaptrolley.user.model.User;

public interface UserService {
    User getUserById(Long userId);

    User createUser(User user);
}
