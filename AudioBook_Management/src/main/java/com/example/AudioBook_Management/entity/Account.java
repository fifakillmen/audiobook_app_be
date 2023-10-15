package com.example.AudioBook_Management.entity;

import com.example.AudioBook_Management.enumPack.Enum_Roles;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "email", nullable = false)
    @JdbcTypeCode(SqlTypes.CHAR)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "create_at")
    private LocalDate create_at;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "email"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> role;
    @OneToOne
    private  User user;

    public Account() {
    }

    public Account(String email, String password, LocalDate create_at, List<Role> role, User user) {
        this.email = email;
        this.password = password;
        this.create_at = create_at;
        this.role = role;
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", create_at=" + create_at +
                ", role=" + role +
                ", user=" + user +
                '}';
    }
}
