package com.taskstorage.repository;

import com.taskstorage.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository implements UserDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session;

    public void createUser(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public List<User> selectAll() {
        List<User> users = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        users = session.createQuery("from User").list();
        return users;
    }

    @Override
    public User selectById(Long id) {
        User user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        // Select with query
        String queryString = "from User where id = :id";
        Query query = session.createQuery(queryString);
        query.setParameter("id", id);

        // Select with built-in method
        // user = session.get(User.class, id);

        user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public User selectByUsername(String username) {
        User user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "from User where username = :username";
        Query query = session.createQuery(queryString);
        query.setParameter("username", username);
        user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public void updateUser(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    @Override
    public void deleteUser(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(id);
        session.getTransaction().commit();
    }

}
