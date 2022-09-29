package com.todoapp.todoapp.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private Boolean finished;
    private TaskStatus taskStatus;

    }


