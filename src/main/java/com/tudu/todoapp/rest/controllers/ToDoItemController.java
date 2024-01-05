package com.tudu.todoapp.rest.controllers;

import com.tudu.todoapp.entities.TodoItem;
import com.tudu.todoapp.repositories.TodoItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/todoitems")
public class ToDoItemController {

    private final TodoItemRepository todoItemRepository;

    @Autowired
    ToDoItemController(TodoItemRepository todoItemRepository){
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
    public ResponseEntity<Page<TodoItem>> getAllToDoItems(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size){

        Page<TodoItem> todoItems = todoItemRepository.findAll(PageRequest.of(page, size));
        return new ResponseEntity<>(todoItems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getToDoItemById(@PathVariable Long id){
        Optional<TodoItem> todoItem = todoItemRepository.findById(id);

        return todoItem.map(item -> new ResponseEntity<>(item, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TodoItem> createToDoItem(@Valid @RequestBody TodoItem todoItem){
        TodoItem createdTodoItem = todoItemRepository.save(todoItem);
        return new ResponseEntity<>(createdTodoItem, HttpStatus.CREATED);
    }
}
