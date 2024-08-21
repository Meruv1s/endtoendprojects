package com.sumanth.backendconcepts.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

@Table(name="users",uniqueConstraints = {  @UniqueConstraint(columnNames = {"email"})})
public class Users {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(Long id, String password, String email, String name) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public Users() {
    }
}
