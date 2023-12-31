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
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private User user;
}



