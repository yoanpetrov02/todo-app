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
@Table(name="boards")
public class Board {
    @Id
    @GeneratedValue
    private Long boardId;
    private String title;
    private String description;

    @OneToMany
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "todo_list", cascade = CascadeType.ALL)
    private List<ToDoList> toDoLists;
}
