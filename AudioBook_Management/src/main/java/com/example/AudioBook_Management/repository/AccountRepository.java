package com.example.AudioBook_Management.repository;

import com.example.AudioBook_Management.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
