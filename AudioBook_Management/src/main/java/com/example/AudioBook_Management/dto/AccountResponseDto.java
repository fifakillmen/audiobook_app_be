package com.example.AudioBook_Management.dto;

import com.example.AudioBook_Management.entity.Role;
import com.example.AudioBook_Management.entity.User;
import com.example.AudioBook_Management.enumPack.Enum_Roles;

import java.util.List;

public class AccountResponseDto {
    private String email;
    private List<Role> roles;

    private String accessToken;
    private User user;
    public AccountResponseDto() {
    }

    public AccountResponseDto(String email, List<Role> roles, String accessToken, User user) {
        this.email = email;
        this.roles = roles;
        this.accessToken = accessToken;
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AccountResponseDto{" +
                "email='" + email + '\'' +
                ", roles=" + roles +
                ", accessToken='" + accessToken + '\'' +
                ", user=" + user +
                '}';
    }
}
