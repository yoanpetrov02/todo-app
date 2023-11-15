package com.tudu.todoapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private Long userId;
    private String displayName;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    UserAccount userAccount;
}
