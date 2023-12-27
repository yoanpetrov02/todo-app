package com.tudu.todoapp.repositories;

import com.tudu.todoapp.entities.User;
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
class UserRepoTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testExistsUserByIdSuccess() {

        Optional<User> result = userRepository.existsUserById(123);
        assertThat(result, is(equalTo(true));
    }


    @Test
    void testExistsUserByIdFailure() {

        Optional<User> result = userRepository.existsUserById(100);
        assertThat(result, is(equalTo(false));
    }

    @Test
    void testFindUserByUserIdSuccess() {

        Optional<User> result = userRepository.findUserById(123);

        assertThat(result.get().getFirstName())
            .isNotNull()
            .isEqualTo("John");
    }
}
