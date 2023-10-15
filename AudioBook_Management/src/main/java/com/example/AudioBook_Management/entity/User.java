package com.example.AudioBook_Management.entity;

import com.example.AudioBook_Management.enumPack.Enum_Gender;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)
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

}
