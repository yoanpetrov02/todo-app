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

    @OneToMany(mappedBy = "toDoLists", cascade = CascadeType.ALL)
    private Board board;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private List<ToDoItem> toDoItems;
}
