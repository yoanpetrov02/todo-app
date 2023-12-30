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

    public User(String displayName, UserAccount userAccount, List<Board> boards) {
        this.displayName = displayName;
        this.userAccount = userAccount;
        this.boards = boards;
    }

    public Long getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
}
