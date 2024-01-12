package com.tudu.todoapp.dto;

import com.tudu.todoapp.entities.TodoList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoItemDTO {

    private Boolean completed;
}
