package com.todoapp.todoapp.persistence.Repository;

import com.todoapp.todoapp.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface TaskRepository extends JpaRepository<Task,Long>{

}
