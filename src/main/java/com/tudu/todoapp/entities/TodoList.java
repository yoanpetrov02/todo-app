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

    public TodoList(String title, String description, Board board, List<TodoItem> todoItems) {
        this.title = title;
        this.description = description;
        this.board = board;
        this.todoItems = todoItems;
    }

    public Long getListId() {
        return listId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Board getBoard() {
        return board;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }
}
