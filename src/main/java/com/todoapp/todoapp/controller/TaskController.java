package com.todoapp.todoapp.controller;

import com.todoapp.todoapp.service.TaskService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
}
