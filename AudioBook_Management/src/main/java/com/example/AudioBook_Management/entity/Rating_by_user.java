package com.example.AudioBook_Management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rating_by_user")
public class Rating_by_user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book  book;
    @Column(name = "rating_des")
    private String ratting_des;
    @Column(name = "rating")
    private Float rating;

    public Rating_by_user() {
    }

    public Rating_by_user(Long id, User user, Book book, String ratting_des, Float rating) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.ratting_des = ratting_des;
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getRatting_des() {
        return ratting_des;
    }

    public void setRatting_des(String ratting_des) {
        this.ratting_des = ratting_des;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Rating_by_user{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", ratting_des='" + ratting_des + '\'' +
                ", rating=" + rating +
                '}';
    }
}
