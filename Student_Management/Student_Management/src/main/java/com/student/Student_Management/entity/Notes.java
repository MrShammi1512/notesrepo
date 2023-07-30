package com.student.Student_Management.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Notes")
public class Notes {

    @Id
    private long notesid;
    private String title;
    private String content;

    @ManyToOne
   // @JsonIgnore
    @JoinColumn
    private User user;

    public Notes() {
        super();
    }

    public Notes(long notesid, String title, String content, User user) {
        super();
        this.notesid = notesid;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public long getNotesid() {
        return notesid;
    }

    public void setNotesid(long notesid) {
        this.notesid = notesid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Notes [notesid=" + notesid + ", title=" + title + ", content=" + content + ", user=" + user.getEmail() + "]";
    }
}
