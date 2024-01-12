package com.tudu.todoapp.dto.mappers;

import com.tudu.todoapp.entities.UserAccount;
import com.tudu.todoapp.dto.UserAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserAccountMapper {
    @Mapping(target="UserAccount", source = "UserAccountDto")
    UserAccount dtoToEntity(UserAccountDto dto);
}
