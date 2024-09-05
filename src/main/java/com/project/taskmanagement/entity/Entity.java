package com.project.taskmanagement.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@jakarta.persistence.Entity
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    private String description;

    private LocalDateTime dueDate;
    private boolean completed;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
