package com.tudu.todoapp.repositories;

import com.tudu.todoapp.entities.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
