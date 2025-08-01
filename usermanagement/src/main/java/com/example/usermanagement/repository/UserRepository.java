package com.example.usermanagement.repository;

import com.example.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByNameContainingIgnoreCase(String name);
}
