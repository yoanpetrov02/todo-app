package com.tudu.todoapp.repositories;


import com.tudu.todoapp.entities.TodoItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


//TODO

@DataJpaTest
//@Sql({
//    "/sql/employee_data.sql"
//})
class TodoItemTest {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Test
    void testExistsTodoItemByIdSuccess() {

        Optional<TodoItem> result = todoItemRepository.existsTodoItemById(123);
        assertThat(result, is(equalTo(true));
    }


    @Test
    void testExistsTodoItemByIdFailure() {

        Optional<TodoItem> result = todoItemRepository.existsTodoItemById(100);
        assertThat(result, is(equalTo(false));
    }

    @Test
    void testFindTodoItemByIdSuccess() {

        Optional<TodoItem> result = todoItemRepository.findTodoItemById(123);

        assertThat(result.get().getFirstName())
            .isNotNull()
            .isEqualTo("");
    }
}
