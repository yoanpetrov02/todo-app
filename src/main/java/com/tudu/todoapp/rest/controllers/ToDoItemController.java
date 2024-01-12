package com.tudu.todoapp.rest.controllers;

import com.tudu.todoapp.dto.TodoItemDto;
import com.tudu.todoapp.dto.mappers.TodoItemMapper;
import com.tudu.todoapp.entities.TodoItem;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.services.interfaces.ToDoItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/todoitems")
public class ToDoItemController {

    private final ToDoItemService todoItemService;
    private final TodoItemMapper todoItemMapper;

    @GetMapping
    public ResponseEntity<?> getTodoItemsPage(
        @RequestParam(defaultValue = "1") Integer pageNumber,
        @RequestParam(defaultValue = "10") Integer perPage
    ) {
        List<TodoItem> todoItems = todoItemService.getTodoItemsPage(pageNumber, perPage);
        if(todoItems.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(todoItems, HttpStatus.OK);
    }

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
    public ResponseEntity<?> createToDoItem(@Valid @RequestBody TodoItemDto todoItemDto){
        try{
            TodoItem newTodoItem = todoItemService.createToDoItem(
                todoItemMapper.dtoToEntity(todoItemDto)
            );
            return new ResponseEntity<>(newTodoItem, HttpStatus.OK);
        } catch (ResourceConflictException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateToDoItem(
        @PathVariable Long id,
        @Valid @RequestBody TodoItemDto newTodoData
    ){
        try{
            TodoItem updatedToDoItem = todoItemService.updateToDoItem(id,
                todoItemMapper.dtoToEntity(newTodoData));

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
