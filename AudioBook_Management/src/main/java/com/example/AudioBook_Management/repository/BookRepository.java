package com.example.AudioBook_Management.repository;

import com.example.AudioBook_Management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
