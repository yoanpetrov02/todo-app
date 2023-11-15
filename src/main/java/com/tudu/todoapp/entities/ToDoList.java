package com.tudu.todoapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="todo_lists")
public class ToDoList {
    @Id
    @GeneratedValue
    private Long listId;
    private String title;
    private String description;

    @OneToMany
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "todo_items", cascade = CascadeType.ALL)
    private List<ToDoItem> toDoItems;
}
