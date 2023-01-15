package com.java.intership.practice5.service;

import com.java.intership.practice5.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> readBooks();

    void update(Book book);

    Book read(int id);

    void delete(int id);

    List<Book> findByAuthorId(int id);

    List<Book> findByGenre(String genre);

}
