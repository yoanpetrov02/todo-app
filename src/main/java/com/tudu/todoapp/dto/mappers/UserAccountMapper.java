package com.tudu.todoapp.dto.mappers;

import com.tudu.todoapp.entities.UserAccount;
import com.tudu.todoapp.dto.UserAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserAccountMapper {
    UserAccount dtoToEntity(UserAccountDto dto);
}
