package com.java.intership.practice5.service;

import com.java.intership.practice5.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> readAuthors();

    void update(Author author);

    Author read(int id);

    void delete(int id);
}
