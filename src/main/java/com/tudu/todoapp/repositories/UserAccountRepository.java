package com.tudu.todoapp.repositories;

import com.tudu.todoapp.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    boolean existsUserAccoutById(Long id);
    Optional<UserAccount> findUserAccountById(Long id);
}
