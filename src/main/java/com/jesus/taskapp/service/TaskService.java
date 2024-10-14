package com.jesus.taskapp.service;

import com.jesus.taskapp.mapper.TaskMapper;
import com.jesus.taskapp.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public List<Task> getAllTasks() {
        return taskMapper.getAllTasks();
    }

    public Task getTaskById(int id) {
        return taskMapper.getTaskById(id);
    }

    public void saveTask(Task task) {
        taskMapper.insertTask(task);
    }

    public void updateTask(Task task) {
        taskMapper.updateTask(task);
    }

    public void deleteTask(int id) {
        taskMapper.deleteTask(id);
    }
}
