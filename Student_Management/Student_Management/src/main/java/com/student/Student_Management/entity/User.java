package com.student.Student_Management.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    private String email; // Primary key
    private String name;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Notes> notes = new ArrayList<>();

    public User() {
        super();
    }

    public User(String email, String name, String password) {
        super();
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", name=" + name + ", password=" + password + "]";
    }
}
