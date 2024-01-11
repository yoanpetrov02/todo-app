package com.tudu.todoapp.repositories;

import com.tudu.todoapp.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    @Query(nativeQuery = true, value = "SELECT account_id, email, password, role FROM user_accounts as u WHERE u.email = ?")
    Optional<UserAccount> findUserAccountByEmail(String email);
}
