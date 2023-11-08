package com.example.AudioBook_Management.service.serviceImpl;

import com.example.AudioBook_Management.entity.Account;
import com.example.AudioBook_Management.entity.Role;
import com.example.AudioBook_Management.enumPack.Enum_Roles;
import com.example.AudioBook_Management.repository.AccountRepository;
import com.example.AudioBook_Management.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Value("${default-password}")
    private String DEFAULT_PASS;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccountLisener(String email, String password, String re_password) {
       Account account=  accountRepository.findByEmail(email);
        if (account==null&&password.equals(re_password)){
            Account a= new Account();
            a.setEmail(email);
            a.setPassword(passwordEncoder.encode(DEFAULT_PASS));
            Role r= new Role();
            r.setName(Enum_Roles.USER);
            r.setId(2L);
            List<Role> roles= new ArrayList<>();
            roles.add(r);
            a.setRole(roles);
            a.setCreate_at(LocalDate.now());
           return accountRepository.save(a);
        }
        return null;
    }
}
