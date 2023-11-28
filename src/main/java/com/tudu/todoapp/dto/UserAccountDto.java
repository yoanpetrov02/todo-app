package com.tudu.todoapp.dto;

import com.tudu.todoapp.security.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDto {

    private String email;
    private String password;
    private Role role;
}
