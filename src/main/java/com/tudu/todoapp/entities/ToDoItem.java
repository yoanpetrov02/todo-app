package com.tudu.todoapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="todo_items")
public class ToDoItem {
    @Id
    @GeneratedValue
    private Long itemId;
    private Boolean completed;

    @OneToMany(mappedBy = "toDoItems", cascade = CascadeType.ALL)
    private ToDoList toDoList;
}
