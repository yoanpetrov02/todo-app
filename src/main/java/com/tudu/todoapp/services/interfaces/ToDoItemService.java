package com.tudu.todoapp.services.interfaces;

import com.tudu.todoapp.entities.TodoItem;
import com.tudu.todoapp.entities.TodoList;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;

import java.util.List;

/**
 * Business logic related to {@code ToDoItem} entities.
 */
public interface ToDoItemService {

    /**
     * Returns all to do items.
     */
    List<TodoItem> getAllTodoItems();

    /**
     * Returns the to do item with that id.
     *
     * @throws ResourceNotFoundException if the board was not found.
     */
    TodoItem getToDoItemById(Long itemId) throws ResourceNotFoundException;

    /**
     * Returns a page containing to do items.
     *
     * @throws ResourceNotFoundException if the page was not found.
     */
    List<TodoItem> getTodoItemsPage(int pageNumber, int perPage);

    /**
     * Creates the new board in the database.
     *
     * @param todoItem the to do item's information.
     * @return the saved {@code ToDoItem}.
     * @throws ResourceConflictException if a board with the same id already exists.
     */
    TodoItem createToDoItem(TodoItem todoItem) throws ResourceConflictException;

    /**
     * Updates the board with the given id with the new data.
     *
     * @param itemId the id of the to do item.
     * @param newTodoItem the new to do item.
     * @return the updated {@code ToDoItem}.
     * @throws ResourceNotFoundException if the board was not found.
     */
    TodoItem updateToDoItem(Long itemId, TodoItem newTodoItem) throws ResourceNotFoundException;

    /**
     * Deletes the to do item with the given id.
     *
     * @param itemId the id of the to do item.
     */
    void deleteToDoItemById(Long itemId) throws ResourceNotFoundException;

    /**
     * Deletes all to do items from the database.
     */
    void deleteAllToDoItems();

}
