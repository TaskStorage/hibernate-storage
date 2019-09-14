package com.taskstorage.repository;

import com.taskstorage.model.User;

import java.util.List;

interface UserDAO {
    List<User> selectAll();
    User selectById(Long id);
    User selectByUsername(String username);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}
