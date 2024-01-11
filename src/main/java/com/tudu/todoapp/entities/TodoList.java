package com.tudu.todoapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo_lists")
public class TodoList {

    @Id
    @GeneratedValue
    @Column(name = "list_id")
    private Long listId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    private Board board;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
    private List<TodoItem> todoItems = new ArrayList<>();
}
