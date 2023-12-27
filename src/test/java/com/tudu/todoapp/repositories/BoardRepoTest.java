package com.tudu.todoapp.repositories;

import com.tudu.todoapp.entities.Board;
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
class BoardRepoTest {

    @Autowired
    private BoardRepository boardRepository;


    @Test
    void testExistsBoardByIdSuccess() {

        Optional<Board> result = boardRepository.existsBoardById(123);
        assertThat(result, is(equalTo(true));
    }


    @Test
    void testExistsBoardByIdFailure() {

        Optional<Board> result = boardRepository.existsBoardById(100);
        assertThat(result, is(equalTo(false));
    }



    @Test
    void testFindBoardByIdSuccess() {

        Optional<Board> result = boardRepository.findBoardById(123);

        assertThat(result.get().getFirstName())
            .isNotNull()
            .isEqualTo("");
    }
}
