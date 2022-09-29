package com.todoapp.todoapp.mapper;

import com.todoapp.todoapp.persistence.entity.Task;
import com.todoapp.todoapp.persistence.entity.TaskStatus;
import com.todoapp.todoapp.service.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskDTOtoTask implements IMapper<TaskDTO, Task> {
    @Override
    public Task map(TaskDTO in) {
        Task task = new Task();
        task.setTitulo(in.getTitulo());
        task.setDescripcion(in.getDescripcion());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
