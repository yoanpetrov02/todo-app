package com.tudu.todoapp.repositories;


import com.tudu.todoapp.entities.UserAccount;
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
    private UserAccountRepository userAccountRepository;

    @Test
    void testExistsUserAccountByIdSuccess() {

        Optional<UserAccount> result = userAccountRepository.existsUserAccoutById(123);
        assertThat(result, is(equalTo(true));
    }


    @Test
    void testExistsUserAccountByIdFailure() {

        Optional<UserAccount> result = userAccountRepository.existsUserAccoutById(100);
        assertThat(result, is(equalTo(false));
    }


    @Test
    void testFindUserAccountByUserAccountIdSuccess() {

        Optional<UserAccount> result = userAccountRepository.findUserAccountById(123);

        assertThat(result.get().getFirstName())
            .isNotNull()
            .isEqualTo("John");
    }
}
