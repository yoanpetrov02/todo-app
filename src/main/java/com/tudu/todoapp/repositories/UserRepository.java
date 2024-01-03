package com.tudu.todoapp.repositories;

import com.tudu.todoapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByDisplayName(String displayName);

    @Query("SELECT u FROM Users u WHERE lower(u.displayName) LIKE :#{#displayName == null || #displayName.isEmpty() ? '%' : #displayName+'%'}")
    List<User> filterUsersByDisplayName(String displayName);
}


