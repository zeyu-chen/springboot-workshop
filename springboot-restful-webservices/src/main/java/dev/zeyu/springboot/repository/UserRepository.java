package dev.zeyu.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.zeyu.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
