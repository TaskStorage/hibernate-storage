package com.taskstorage.repository;

import com.taskstorage.model.Task;

import java.util.List;

public interface TaskDao {
    List<Task> selectAll();
    Task selectById(Long id);
    void createTask(Task task);
    void updateTask(Task task);
    void deleteTask(Long id);
}
