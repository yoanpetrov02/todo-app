package com.tudu.todoapp.rest.controllers;

import com.tudu.todoapp.entities.TodoItem;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.services.interfaces.ToDoItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/todoitems")
public class ToDoItemController {

    private final ToDoItemService todoItemService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getToDoItemById(@PathVariable Long id){
        try{
            TodoItem todoItem = todoItemService.getToDoItemById(id);
            return new ResponseEntity<>(todoItem, HttpStatus.OK);
        } catch(ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createToDoItem(@Valid @RequestBody TodoItem todoItem){
        try{
            TodoItem newTodoItem = todoItemService.createToDoItem(todoItem);
            return new ResponseEntity<>(newTodoItem, HttpStatus.OK);
        } catch (ResourceConflictException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateToDoItem(
        @PathVariable Long id,
        @Valid @RequestBody TodoItem newTodoData
    ){
        try{
            TodoItem updatedToDoItem = todoItemService.updateToDoItem(id, newTodoData);
            return new ResponseEntity<>(updatedToDoItem, HttpStatus.OK);
        } catch(ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToDoItemById(@PathVariable Long id){
        try{
            todoItemService.deleteToDoItemById(id);
            return new ResponseEntity<>("To do item deletion successful.", HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllToDoItems(){
        todoItemService.deleteAllToDoItems();
        return new ResponseEntity<>("Deletion of all items was successful.", HttpStatus.OK);
    }
}
