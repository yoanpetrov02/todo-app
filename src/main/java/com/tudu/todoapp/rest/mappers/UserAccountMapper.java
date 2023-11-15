package com.tudu.todoapp.rest.mappers;

import com.tudu.todoapp.entities.UserAccount;
import com.tudu.todoapp.rest.dto.UserAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserAccountMapper {

    UserAccount dtoToEntity(UserAccountDto dto);
}
