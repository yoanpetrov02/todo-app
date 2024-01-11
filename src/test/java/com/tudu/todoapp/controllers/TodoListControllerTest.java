package com.tudu.todoapp.controllers;

import com.tudu.todoapp.entities.TodoList;
import com.tudu.todoapp.rest.controllers.TodoListController;
import com.tudu.todoapp.services.implementations.TodoListServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = TodoListController.class)
class TodoListControllerTest {

    @MockBean
    private TodoListServiceImpl todoListService;

    @InjectMocks
    private TodoListController todoListController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testGetTodoListsPerPage() {
        // Arrange
        int currentPage = 1;
        int perPage = 10;
        List<TodoList> todoLists = Arrays.asList(new TodoList(), new TodoList());

        when(todoListService.getTodoListsPage(currentPage, perPage)).thenReturn(todoLists);

        List<TodoList> actualResult = todoListController.getTodoListsPerPage(currentPage, perPage);
        assertEquals(todoLists, actualResult);
    }


    @Test
    void testGetTodoListById() {

        Long todoListId = 1L;
        TodoList todoList = TodoList.builder().title("First").build();

        when(todoListService.getTodoListById(todoListId)).thenReturn(todoList);

        TodoList actualResult = todoListController.getTodoListById(todoListId);
        assertEquals(todoList, actualResult);
    }


    @Test
    void testCreateTodoList() {

        TodoList todoList = TodoList.builder().title("First").build();

        ResponseEntity<?> actualResult = todoListController.createTodoList(todoList);
        assertEquals(HttpStatus.OK, actualResult.getStatusCode());
    }


    @Test
    void testUpdateTodoList() {

        Long todoListId = 1L;
        TodoList newData = TodoList.builder().title("First").build();
        TodoList updatedTodoList = TodoList.builder().title("Second").build();

        when(todoListService.updateTodoList(todoListId, newData)).thenReturn(updatedTodoList);

        ResponseEntity<TodoList> actualResult = todoListController.updateTodoList(todoListId, newData);

        assertEquals(HttpStatus.OK, actualResult.getStatusCode());
        assertEquals(updatedTodoList, actualResult.getBody());
    }


    @Test
    void testDeleteAllTodoLists() {

        ResponseEntity<?> actualResult = todoListController.deleteAllTodoLists();

        assertEquals(HttpStatus.OK, actualResult.getStatusCode());
    }


    @Test
    void testDeleteTodoListById() {

        Long todoListId = 1L;
        TodoList todoList = TodoList.builder().title("First").build();

        when(todoListService.getTodoListById(todoListId)).thenReturn(todoList);

        ResponseEntity<?> actualResult = todoListController.deleteTodoListById(todoListId);
        assertEquals(HttpStatus.OK, actualResult.getStatusCode());
    }
}
