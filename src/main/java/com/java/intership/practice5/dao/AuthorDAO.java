package com.java.intership.practice5.dao;

import com.java.intership.practice5.entity.Author;

import java.util.List;

public interface AuthorDAO {

    List<Author> readAllAuthors();

    void update(Author author);

    Author read(int id);

    void delete(int id);

}
