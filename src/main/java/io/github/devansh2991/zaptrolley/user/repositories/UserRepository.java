package io.github.devansh2991.zaptrolley.user.repositories;

import io.github.devansh2991.zaptrolley.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    List<User> findByEmail(String email);

    User findFirstByUserId(long userId);
}
