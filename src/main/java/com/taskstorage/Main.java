package com.taskstorage;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        User user = new User("tLogin", "tPassword");

        Task task1 = new Task("Cont1", "Desc1", user);
        Task task2 = new Task("Cont2", "Cont2", user);

        user.setTasks(new ArrayList<Task>());
        user.getTasks().add(task1);
        user.getTasks().add(task2);

        User user2 = new User("tLogin2", "tPassword2");

        Task task3 = new Task("Cont3", "Desc4", user2);
        Task task4 = new Task("Cont4", "Desc4", user2);

        user.getTasks().add(task3);
        user.getTasks().add(task4);

        session.save(user);
        session.save(user2);

        session.getTransaction().commit();
        session.close();
    }
}