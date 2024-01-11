package com.tudu.todoapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo_items")
public class TodoItem {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "completed")
    private Boolean completed;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_id")
    private TodoList todoList;


}
