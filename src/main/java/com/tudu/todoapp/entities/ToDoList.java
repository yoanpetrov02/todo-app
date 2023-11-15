package com.tudu.todoapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="todo_lists")
public class ToDoList {
    @Id
    @GeneratedValue
    private Long listId;
    private String title;
    private String description;
}
