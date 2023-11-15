package com.tudu.todoapp.rest.dto;

import com.tudu.todoapp.security.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDto {

    private String email;
    private String password;
    private Role role;
}
