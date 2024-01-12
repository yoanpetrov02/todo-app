package com.tudu.todoapp.dto;

import com.tudu.todoapp.security.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDto {

    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private Role role;
}
