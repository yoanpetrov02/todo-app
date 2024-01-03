package com.tudu.todoapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "display_name", unique = true)
    private String displayName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    UserAccount userAccount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Board> boards;
}
