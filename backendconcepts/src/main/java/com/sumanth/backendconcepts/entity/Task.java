package com.sumanth.backendconcepts.entity;

import jakarta.persistence.*;


@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskname;
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Task(Long id, String taskname, Users users) {
        this.id = id;
        this.taskname = taskname;
        this.users = users;
    }

    public Task() {
    }
}
