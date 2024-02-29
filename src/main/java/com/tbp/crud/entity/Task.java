package com.tbp.crud.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;



    // Example Many-to-One relationship from Task to User
   /* @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Example Many-to-One relationship from Task to TaskState
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "task_state_id", nullable = false)
    private TaskState taskState;*/

}


