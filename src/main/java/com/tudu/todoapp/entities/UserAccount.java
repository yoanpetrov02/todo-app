package com.tudu.todoapp.entities;

import com.tudu.todoapp.security.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue
    private Long accountId;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
