package com.java.intership.practice5.service;

import com.java.intership.practice5.dao.AuthorDAO;
import com.java.intership.practice5.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public List<Author> readAuthors() {
        return authorDAO.readAllAuthors();
    }

    @Override
    @Transactional
    public void update(Author author) {
        authorDAO.update(author);
    }

    @Override
    @Transactional
    public Author read(int id) {
        return authorDAO.read(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        authorDAO.delete(id);
    }
}
