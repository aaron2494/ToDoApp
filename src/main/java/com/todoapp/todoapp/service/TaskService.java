package com.todoapp.todoapp.service;

import com.todoapp.todoapp.mapper.TaskDTOtoTask;
import com.todoapp.todoapp.persistence.Repository.TaskRepository;
import com.todoapp.todoapp.persistence.entity.Task;
import com.todoapp.todoapp.service.dto.TaskDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskDTOtoTask mapper;
    private final TaskRepository taskRepository;

    public TaskService(TaskDTOtoTask mapper, TaskRepository taskRepository) {
        this.mapper = mapper;
        this.taskRepository = taskRepository;
    }
    public Task createTask(TaskDTO taskDTO){
        Task task= mapper.map(taskDTO);
        return this.taskRepository.save(task);
    }

}
