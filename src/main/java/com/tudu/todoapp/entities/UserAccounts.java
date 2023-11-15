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
public class UserAccounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private String role;
}
