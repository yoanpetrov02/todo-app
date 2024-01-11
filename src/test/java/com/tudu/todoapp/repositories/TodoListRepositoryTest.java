package com.tudu.todoapp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tudu.todoapp.entities.TodoList;

@SpringBootTest
class TodoListRepositoryTest {

    @Autowired
    private TodoListRepository todoListRepository;


    public void testFilterTodoListsByTitle() {

        TodoList todoList1 = TodoList.builder().title("First").build();
        TodoList todoList2 = TodoList.builder().title("Second").build();
        TodoList todoList3 = TodoList.builder().title("Third").build();

        todoListRepository.saveAll(List.of(todoList1, todoList2, todoList3));

        List<TodoList> filteredLists = todoListRepository.filterTodoListsByTitle("First");

        assertEquals(1, filteredLists.size());
        assertEquals("First", filteredLists.get(0).getTitle());
    }
}
