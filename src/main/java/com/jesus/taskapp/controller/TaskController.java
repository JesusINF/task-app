package com.jesus.taskapp.controller;

import com.jesus.taskapp.model.Task;
import com.jesus.taskapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "task-list";
    }

    @GetMapping("/task/new")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @GetMapping("/task/edit/{id}")
    public String editTaskForm(@PathVariable("id") int id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task-form";
    }

    @PostMapping("/task/save")
    public String saveOrUpdateTask(@ModelAttribute Task task) {
        if (task.getId() > 0) {
            taskService.updateTask(task);
        } else {
            taskService.saveTask(task);
        }
        return "redirect:/tasks";
    }

    @PostMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
