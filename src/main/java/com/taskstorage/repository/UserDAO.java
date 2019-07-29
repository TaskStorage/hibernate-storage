package com.taskstorage.repository;

import com.taskstorage.model.User;

import java.util.List;

public interface UserDAO {
    void createUser(User user);
    List<User> selectAll();
    User selectById(Long id);
    User selectByUsername(String username);
    void updateUser(User user);
    void deleteUser(Long id);
}
