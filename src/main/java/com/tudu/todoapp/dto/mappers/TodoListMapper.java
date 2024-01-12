package com.tudu.todoapp.dto.mappers;

import com.tudu.todoapp.dto.TodoListDto;
import com.tudu.todoapp.entities.TodoList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TodoListMapper {
    @Mapping(target="TodoList", source = "TodoListDto")
    TodoList dtoToEntity(TodoListDto todoListDTO);
}
