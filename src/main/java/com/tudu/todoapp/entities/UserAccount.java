package com.tudu.todoapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tudu.todoapp.security.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_accounts")
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

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private User user;
}



