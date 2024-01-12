package com.tudu.todoapp.dto.mappers;

import com.tudu.todoapp.dto.BoardDto;
import com.tudu.todoapp.entities.Board;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BoardMapper {
    @Mapping(target="Board", source = "BoardDto")
    Board dtoToEntity(BoardDto boardDto);
}
