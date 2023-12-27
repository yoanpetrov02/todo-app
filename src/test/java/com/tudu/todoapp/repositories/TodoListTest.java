package com.tudu.todoapp.repositories;


import com.tudu.todoapp.entities.TodoList;
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
class TodoListTest {

    @Autowired
    private TodoListRepository todoListRepository;

    @Test
    void testExistsTodoListByIdSuccess() {

        Optional<TodoList> result = todoListRepository.existsTodoListById(123);
        assertThat(result, is(equalTo(true));
    }


    @Test
    void testExistsTodoListByIdFailure() {

        Optional<TodoList> result = todoListRepository.existsTodoListById(100);
        assertThat(result, is(equalTo(false));
    }


    @Test
    void testFindTodoListByIdSuccess() {

        Optional<TodoList> result = todoListRepository.findTodoListById(123);

        assertThat(result.get().getFirstName())
            .isNotNull()
            .isEqualTo("");
    }
}
