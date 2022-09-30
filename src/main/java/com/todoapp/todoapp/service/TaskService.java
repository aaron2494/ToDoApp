package com.todoapp.todoapp.service;

import com.todoapp.todoapp.exceptions.ToDoExceptions;
import com.todoapp.todoapp.mapper.TaskDTOtoTask;
import com.todoapp.todoapp.persistence.Repository.TaskRepository;
import com.todoapp.todoapp.persistence.entity.Task;
import com.todoapp.todoapp.persistence.entity.TaskStatus;
import com.todoapp.todoapp.service.dto.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public List<Task> findAllTasks(){
        return this.taskRepository.findAll();
    }
    public List<Task> findAllTaskStatus(TaskStatus status){
        return this.taskRepository.findAllByTaskStatus(status);
    }
    @Transactional
    public void updateTaskFinished(Long id){
        Optional<Task>optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isEmpty()){
            throw new ToDoExceptions("task not found", HttpStatus.NOT_FOUND);
        }
                    this.taskRepository.markTaskFinished(id);
        }
    public void deleteById(Long id){
        Optional<Task>optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isEmpty()){
            throw new ToDoExceptions("task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }

    }


