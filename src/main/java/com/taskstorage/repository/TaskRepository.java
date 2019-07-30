package com.taskstorage.repository;

import com.taskstorage.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TaskRepository implements TaskDao {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session;

    @Override
    public List<Task> selectAll() {
        List<Task> tasks = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        tasks = session.createQuery("from Task").list();
        return tasks;
    }

    @Override
    public Task selectById(Long id) {
        Task task = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        // Select with query
        String queryString = "from Task where id = :id";
        Query query = session.createQuery(queryString);
        query.setParameter("id", id);

        // Select with built-in method
        // user = session.get(Task.class, id);

        task = (Task) query.uniqueResult();
        return task;
    }

    @Override
    public void createTask(Task task) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(task);
        session.getTransaction().commit();
    }

    @Override
    public void updateTask(Task task) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(task);
        session.getTransaction().commit();
    }

    @Override
    public void deleteTask(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();

        Task task = new Task();
        task.setId(id);
        session.delete(task);

        session.getTransaction().commit();
    }
}
