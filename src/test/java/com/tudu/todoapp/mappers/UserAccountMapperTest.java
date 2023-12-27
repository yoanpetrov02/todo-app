package com.tudu.todoapp.dto.mappers;

import com.tudu.todoapp.dto.UserAccountDto;
import com.tudu.todoapp.entities.UserAccount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mapstruct.factory.Mappers;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UserAccountMapperTest {

    private final UserAccountMapper underTest = Mappers.getMapper(UserAccountMapper.class);

    @ParameterizedTest
    @MethodSource("paramProvider")
    void convertDtoToEntityTest(UserAccountDto dto, String[] emptyFields) {
        UserAccount user = underTest.convertDtoToEntity(dto, 1L);
        assertThat(user)
            .isNotNull()
            .hasNoNullFieldsOrPropertiesExcept(emptyFields);
    }


    private static Stream<Arguments> paramProvider() {
        return Stream.of(
            Arguments.of(
                new UserAccountDto("georgi.petrov123@gmail.com", "A&b7*cdEfG", Role.USER),
                new String[]{"email", "password", "role"}
            ),
            Arguments.of(
                new UserAccountDto("nikolai.georgiev@abv.bg", "2#hKpLm9oP", Role.USER),
                new String[]{"email", "password", "role"}
            ),
            Arguments.of(
                new UserAccountDto("vania.ivanova@gmail.com", "Xyz!456AbC", Role.USER),
                new String[]{"email", "password", "role"}
            )
        );
    }
}
