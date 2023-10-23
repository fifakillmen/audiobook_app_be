package com.example.AudioBook_Management.repository;

import com.example.AudioBook_Management.entity.Rating_by_user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rating_by_userRepository extends JpaRepository<Rating_by_user, Long> {
}
