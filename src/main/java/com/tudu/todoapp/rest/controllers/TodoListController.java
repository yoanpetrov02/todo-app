package com.tudu.todoapp.rest.controllers;

import com.tudu.todoapp.entities.TodoList;

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
    public List<TodoList> getTodoListsPerPage(
        @RequestParam(defaultValue="1") int currentPage, @RequestParam int perPage) {

        return todoListService.getTodoListsPage(currentPage, perPage);
    }


    @GetMapping("/{id}")
    public TodoList getTodoListById(@PathVariable Long id) {
        return todoListService.getTodoListById(id);
    }


    @PostMapping
    public ResponseEntity<?> createTodoList(@RequestBody TodoList todoList) {

        todoListService.createTodoList(todoList);
        return new ResponseEntity<>("created yea", HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TodoList> updateTodoList(@PathVariable Long id, @RequestBody TodoList newData) {
        return new ResponseEntity<>(todoListService.updateTodoList(id, newData), HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteAllTodoLists() {

        todoListService.deleteAllTodoLists();

        return new ResponseEntity<>("All todo lists have been successfully deleted", HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodoListById(@PathVariable Long id) {

        TodoList todoList = todoListService.getTodoListById(id);
        todoListService.deleteTodoListById(id);

        return new ResponseEntity<>("Todo list has been successfully deleted", HttpStatus.OK);
    }

}
