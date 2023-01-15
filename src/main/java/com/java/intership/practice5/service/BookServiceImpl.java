package com.java.intership.practice5.service;

import com.java.intership.practice5.dao.BookDAO;
import com.java.intership.practice5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public List<Book> readBooks() {
//        Pageable pageable = PageRequest.of(pageNo, pageSize);
//        Page<Book> bookPage = bookRepository.findAll(pageable);
        return bookDAO.readAllBooks();
    }

    @Override
    @Transactional
    public void update(Book book) {
        bookDAO.update(book);
    }

    @Override
    @Transactional
    public Book read(int id) {
        return bookDAO.read(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        bookDAO.delete(id);
    }

    @Override
    @Transactional
    public List<Book> findByAuthorId(int id) {
        return bookDAO.findByAuthorId(id);
    }

    @Override
    @Transactional
    public List<Book> findByGenre(String genre) {
        return bookDAO.findByGenre(genre);
    }
}
