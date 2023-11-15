package com.tudu.todoapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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
    private String role;
}
