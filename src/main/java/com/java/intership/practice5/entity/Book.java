package com.java.intership.practice5.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "price")
    private int price;

    public Book() {
    }

    public Book(int id, String name, Author author, String genre, int price) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

}
