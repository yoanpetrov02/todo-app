package com.tudu.todoapp.services.implementations;

import com.tudu.todoapp.entities.TodoList;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.repositories.TodoListRepository;
import com.tudu.todoapp.services.interfaces.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepository todoListRepository;

    @Override
    public List<TodoList> getAllTodoLists() {
        return todoListRepository.findAll();
    }

    @Override
    public List<TodoList> getTodoListsPage(int pageNumber, int perPage) {
        int pageIndex = pageNumber - 1;
        Pageable page = PageRequest.of(pageIndex, perPage);
        return todoListRepository.findAll(page).toList();
    }

    @Override
    public TodoList getTodoListById(Long todoListId) {
        return todoListRepository.findById(todoListId)
            .orElseThrow(() -> new ResourceNotFoundException("The todo list with the specified id was not found."));
    }

    @Override
    public List<TodoList> filterTodoListsByTitle(String title) {
        return todoListRepository.filterTodoListsByTitle(title);
    }

    @Override
    public TodoList createTodoList(TodoList todoList) {
        if (todoList.getListId() != null && todoListRepository.existsById(todoList.getListId())) {
            throw new ResourceConflictException("A todo list with the same id already exists.");
        }
        return todoListRepository.save(todoList);
    }


    @Override
    public TodoList updateTodoList(Long listId, TodoList newData) {
        try {
            TodoList dbTodoList = todoListRepository.findById(listId)
                .orElseThrow(() -> new ResourceNotFoundException("The todo list with the specified id was not found."));

            dbTodoList.setTitle(newData.getTitle());
            dbTodoList.setDescription(newData.getDescription());

            return todoListRepository.save(dbTodoList);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceConflictException("A todo list with that title or description already exists.");
        }
    }

    @Override
    public void deleteAllTodoLists() {
        todoListRepository.deleteAll();
    }

    @Override
    public void deleteTodoListById(Long listId) {
        if (!todoListRepository.existsById(listId)) {
            throw new ResourceNotFoundException("The todo list with the specified id was not found.");
        }
        todoListRepository.deleteById(listId);
    }
}
