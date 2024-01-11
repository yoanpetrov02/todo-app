package com.tudu.todoapp.services.interfaces;

import com.tudu.todoapp.entities.TodoItem;
import com.tudu.todoapp.entities.TodoList;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ToDoItemService {

    List<TodoItem> getAllTodoItems();

    TodoItem getToDoItemById(Long itemId);

    TodoItem createToDoItem(TodoItem todoItem) throws ResourceConflictException;

    TodoItem updateToDoItem(Long itemId, TodoItem newTodoItem) throws ResourceNotFoundException;

    void deleteToDoItemById(Long itemId) throws ResourceNotFoundException;

    void deleteAllToDoItems();

}
