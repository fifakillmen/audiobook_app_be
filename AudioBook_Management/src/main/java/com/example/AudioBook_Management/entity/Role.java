package com.example.AudioBook_Management.entity;

import com.example.AudioBook_Management.enumPack.Enum_Roles;
import jakarta.persistence.*;
@Entity
@Table(name = "Role")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Enum_Roles name;


    public Role() {
    }

    public Role(Long id, Enum_Roles name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enum_Roles getName() {
        return name;
    }

    public void setName(Enum_Roles name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
