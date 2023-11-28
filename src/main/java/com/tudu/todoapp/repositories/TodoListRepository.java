package com.tudu.todoapp.repositories;

import com.tudu.todoapp.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
}
