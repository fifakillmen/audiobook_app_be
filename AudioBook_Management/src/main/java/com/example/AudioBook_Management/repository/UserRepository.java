package com.example.AudioBook_Management.repository;

import com.example.AudioBook_Management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
