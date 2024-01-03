package com.tudu.todoapp.services.interfaces;

import com.tudu.todoapp.entities.TodoList;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;

import java.util.List;

public interface TodoListService {

    List<TodoList> getAllTodoLists();

    List<TodoList> getTodoListsPage(int pageNumber, int perPage);

    List<TodoList> filterTodoListsByTitle(String title);

    TodoList getTodoListById(Long listId) throws ResourceNotFoundException;

    TodoList createTodoList(TodoList todoList) throws ResourceConflictException;

    TodoList updateTodoList(Long listId, TodoList newData) throws ResourceNotFoundException, ResourceConflictException;

    void deleteAllTodoLists();

    void deleteTodoListById(Long listId) throws ResourceNotFoundException;
}


