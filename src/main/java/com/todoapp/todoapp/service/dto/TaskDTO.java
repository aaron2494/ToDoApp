package com.todoapp.todoapp.service.dto;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskDTO {

    private String titulo;
    private String descripcion;
    private LocalDateTime eta;
}
