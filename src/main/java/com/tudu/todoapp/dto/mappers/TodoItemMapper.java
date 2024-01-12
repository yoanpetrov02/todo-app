package com.tudu.todoapp.dto.mappers;

import com.tudu.todoapp.dto.TodoItemDto;
import com.tudu.todoapp.entities.TodoItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TodoItemMapper {
    @Mapping(target="TodoItem", source = "TodoItemDTO")
    TodoItem dtoToEntity(TodoItemDto todoItemDTO);
}
