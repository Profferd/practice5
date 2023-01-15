package com.java.intership.practice5.dao;

import com.java.intership.practice5.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Author> readAllAuthors() {
        Session session = sessionFactory.getCurrentSession();

        Query<Author> query = session.createQuery("FROM Author", Author.class);
        List<Author> list = query.getResultList();

        return list;
    }

    @Override
    public void update(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(author);
    }

    @Override
    public Author read(int id) {
        Session session = sessionFactory.getCurrentSession();
        Author author = session.get(Author.class, id);

        return author;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Author> query = session.createQuery("DELETE FROM Author " + "WHERE id =:authorId");
        query.setParameter("authorId", id);
        query.executeUpdate();
    }

}
