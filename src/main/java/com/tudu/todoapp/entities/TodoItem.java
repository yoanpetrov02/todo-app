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
public class TodoItem {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "completed")
    private Boolean completed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_id")
    private TodoList todoList;


    public TodoItem(Boolean completed, TodoList todoList) {
        this.completed = completed;
        this.todoList = todoList;
    }

    public Long getItemId() {
        return itemId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }


}
