package com.java.intership.practice5.dao;

import com.java.intership.practice5.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private static final int limitResultsPerPage = 1;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Book> readAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("FROM Book", Book.class);
        return query.list();
    }

    @Override
    public void update(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
    }

    @Override
    public Book read(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);

        return book;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Book> query = session.createQuery("DELETE FROM Book " + "WHERE id =:bookId");
        query.setParameter("bookId", id);
        query.executeUpdate();
    }

    @Override
    public List<Book> findByAuthorId(int id) {
        Session session = sessionFactory.getCurrentSession();
        //String sql = "SELECT  FROM Book WHERE id = Books.author.id";
        Query<Book> query = session.createQuery("FROM Book u WHERE u.author.id =:id");
        query.setParameter("id", id);
        List<Book> list = query.getResultList();

        return list;
    }

    @Override
    public List<Book> findByGenre(String genre) {
        Session session = sessionFactory.getCurrentSession();

        Query<Book> query = session.createQuery("FROM Book u WHERE u.genre =:genre");
        query.setParameter("genre", genre);
        List<Book> list = query.getResultList();

        return list;
    }

}
