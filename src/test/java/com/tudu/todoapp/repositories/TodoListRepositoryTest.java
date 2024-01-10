import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tudu.todoapp.entities.TodoList;
import com.tudu.todoapp.repositories.TodoListRepository;


@SpringBootTest
class TodoListRepositoryTest {

    @Autowired
    private TodoListRepository todoListRepository;


    public void testFilterTodoListsByTitle() {

        TodoList todoList1 = new TodoList("First");
        TodoList todoList2 = new TodoList("Second");
        TodoList todoList3 = new TodoList("Third");

        todoListRepository.saveAll(List.of(todoList1, todoList2, todoList3));

        List<TodoList> filteredLists = todoListRepository.filterTodoListsByTitle("First");

        assertEquals(1, filteredLists.size());
        assertEquals("First", filteredLists.get(0).getTitle());
    }

}


@ParameterizedTest
