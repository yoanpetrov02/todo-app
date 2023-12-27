package com.tudu.todoapp.repositories;

import com.tudu.todoapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserById(Long id);
    Optional<User> findUserById(Long id);
}
