package com.tudu.todoapp.services.implementations;
import com.tudu.todoapp.entities.TodoItem;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.repositories.TodoItemRepository;
import com.tudu.todoapp.services.interfaces.ToDoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ToDoItem Service implementation.
 *
 * @see ToDoItemService
 */
@RequiredArgsConstructor()
@Service
public class ToDoItemServiceImpl implements ToDoItemService {

    private final TodoItemRepository todoItemRepository;

    @Override
    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }

    @Override
    public TodoItem getToDoItemById(Long itemId) {
        return todoItemRepository.findById(itemId)
            .orElseThrow(() -> new ResourceNotFoundException("The to do item with the specified id was not found."));
    }

    @Override
    public List<TodoItem> getTodoItemsPage(int pageNumber, int perPage){
        int pageIndex = pageNumber - 1;
        Pageable page = PageRequest.of(pageIndex, perPage);
        return todoItemRepository.findAll(page).toList();
    }

    @Override
    public TodoItem createToDoItem(TodoItem todoItem){
        if(todoItem.getItemId()!=null && todoItemRepository.existsById(todoItem.getItemId())){
            throw new ResourceConflictException("An item with the same id already exists.");
        }
        return todoItemRepository.save(todoItem);
    }

    @Override
    public TodoItem updateToDoItem(Long itemId, TodoItem newTodoItem){
        TodoItem dbTodoItem = todoItemRepository.findById(itemId)
            .orElseThrow(() -> new ResourceNotFoundException("An item with the specified id was not found."));
        dbTodoItem.setCompleted(newTodoItem.getCompleted());
        return todoItemRepository.save(dbTodoItem);
    }

    @Override
    public void deleteToDoItemById(Long itemId){
        if(!todoItemRepository.existsById(itemId)){
            throw new ResourceNotFoundException("An item with the specified id was not found.");
        }
        todoItemRepository.deleteById(itemId);
    }

    @Override
    public void deleteAllToDoItems() {
        todoItemRepository.deleteAll();
    }
}
