package com.tudu.todoapp.rest.controllers;

import com.tudu.todoapp.entities.TodoList;

import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.services.implementations.TodoListServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/todolists")
public class TodoListController {

    private final TodoListServiceImpl todoListService;

    @GetMapping
    public ResponseEntity<?> getTodoListsPerPage(
        @RequestParam(defaultValue="1") Integer currentPage,
        @RequestParam(defaultValue = "10") Integer perPage
    ) {
        List<TodoList> lists = todoListService.getTodoListsPage(currentPage, perPage);
        if (lists.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(lists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodoListById(@PathVariable Long id) {
        try {
            TodoList list = todoListService.getTodoListById(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTodoList(@RequestBody TodoList todoList) {
        try {
            TodoList created = todoListService.createTodoList(todoList);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (ResourceConflictException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodoList(@PathVariable Long id, @RequestBody TodoList newData) {
        try {
            TodoList updated = todoListService.updateTodoList(id, newData);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping
    public ResponseEntity<?> deleteAllTodoLists() {
        todoListService.deleteAllTodoLists();
        return new ResponseEntity<>("All todo lists have been deleted", HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodoListById(@PathVariable Long id) {
        try {
            todoListService.deleteTodoListById(id);
            return new ResponseEntity<>("Todo list deleted.", HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
