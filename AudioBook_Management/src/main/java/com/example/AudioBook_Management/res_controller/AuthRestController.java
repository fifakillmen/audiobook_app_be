package com.example.AudioBook_Management.res_controller;

import com.example.AudioBook_Management.configuration.CustomUserDetails;
import com.example.AudioBook_Management.configuration.jwt.JwtTokenUtil;
import com.example.AudioBook_Management.dto.AccountRequestDto;
import com.example.AudioBook_Management.dto.AccountResponseDto;
import com.example.AudioBook_Management.entity.Account;
import com.example.AudioBook_Management.service.AccountService;
import com.example.AudioBook_Management.service.serviceImpl.AccountServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class AuthRestController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthRestController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated AccountRequestDto accountRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(accountRequestDto.getEmail(), accountRequestDto.getPassword())
        );
        CustomUserDetails account = (CustomUserDetails) authentication.getPrincipal();

        Account myAccount = account.getAccount();
        AccountResponseDto accountResponseDto = new AccountResponseDto();

        accountResponseDto.setEmail(myAccount.getEmail());
        accountResponseDto.setUser(myAccount.getUser());
        accountResponseDto.setRoles(myAccount.getRole());
        accountResponseDto.setAccessToken(jwtTokenUtil.generateAccessToken(account));

        return ResponseEntity.ok(accountResponseDto);
    }

    @PostMapping("/checkAccessToken")
    public ResponseEntity<?> checkAccessToken(@RequestParam(name = "accessToken") String accessToken) {
        if (jwtTokenUtil.validateAccessToken(accessToken)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(false);
    }


}
