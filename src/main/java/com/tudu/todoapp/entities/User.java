package com.tudu.todoapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    private List<Board> boards;
}
