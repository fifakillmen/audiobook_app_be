package com.example.AudioBook_Management.entity;

import com.example.AudioBook_Management.enumPack.Enum_Gender;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "address")
    private String address;
    @Column(name = "avatar")
    private String avatar;
    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Enum_Gender gender;
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @ManyToMany
    @JoinTable(name = "user_favorites",
               joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> favorites;
    public User() {
    }

    public User(Long id, String name, LocalDate dob, String address, String avatar, Enum_Gender gender, List<Book> favorites) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.avatar = avatar;
        this.gender = gender;
        this.favorites = favorites;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Enum_Gender getGender() {
        return gender;
    }

    public void setGender(Enum_Gender gender) {
        this.gender = gender;
    }

    public List<Book> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Book> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                ", gender=" + gender +
                ", favorites=" + favorites +
                '}';
    }
}
