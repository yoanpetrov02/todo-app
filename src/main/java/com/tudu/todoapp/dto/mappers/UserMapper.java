package com.tudu.todoapp.dto.mappers;

import com.tudu.todoapp.dto.UserDto;
import com.tudu.todoapp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "User", source = "UserDto")
    User dtoToEntity(UserDto userDto);
}
