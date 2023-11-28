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
@Table(name="todo_items")
public class ToDoItem {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long itemId;
    private Boolean completed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_id")
    private ToDoList toDoList;
}
