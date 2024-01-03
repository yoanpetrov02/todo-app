package com.tudu.todoapp.repositories;

import com.tudu.todoapp.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    @Query("SELECT tl FROM todo_lists tl WHERE lower(tl.title) LIKE " +
        ":#{#title == null || #title.isEmpty() ? '%' : #title+'%'}")
    List<TodoList> filterTodoListsByTitle(String title)
}
