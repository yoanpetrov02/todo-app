package com.tudu.todoapp.repositories;

import com.tudu.todoapp.entities.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<Long, ToDoList> {
}
