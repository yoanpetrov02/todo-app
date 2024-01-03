package com.tudu.todoapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="todo_lists")
public class TodoList {

    @Id
    @GeneratedValue
    @Column(name = "list_id")
    private Long listId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
    private List<TodoItem> todoItems;
}
