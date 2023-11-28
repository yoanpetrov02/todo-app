package com.tudu.todoapp.repositories;

import com.tudu.todoapp.entities.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<Long, ToDoItem> {
}
