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
    @Column(name = "item_id")
    private Long itemId;
    private Boolean completed;

    @ManyToOne(cascade = CascadeType.ALL)
    private ToDoList toDoList;
}
