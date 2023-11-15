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

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_id")
    private List<ToDoList> toDoLists;
}
