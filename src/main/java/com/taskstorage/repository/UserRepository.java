package com.taskstorage.repository;

import com.taskstorage.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository implements UserDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session;

    @Override
    public void createUser(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> selectAll() {
        List<User> users;
        session = sessionFactory.openSession();
        session.beginTransaction();
        users = session.createQuery("from User").list();
        session.close();
        return users;
    }

    @Override
    public User selectById(Long id) {
        User user;
        session = sessionFactory.openSession();
        session.beginTransaction();
        // Select with query
        String queryString = "from User where id = :id";
        Query query = session.createQuery(queryString);
        query.setParameter("id", id);

        // Select with built-in method
        // user = session.get(User.class, id);

        user = (User) query.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public User selectByUsername(String username) {
        User user;
        session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "from User where username = :username";
        Query query = session.createQuery(queryString);
        query.setParameter("username", username);
        user = (User) query.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public void updateUser(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUser(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();

        User user = new User();
        user.setId(id);
        session.delete(user);

        session.getTransaction().commit();
        session.close();
    }

}
