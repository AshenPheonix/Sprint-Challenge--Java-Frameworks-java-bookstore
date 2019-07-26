package com.brandonporter.sprintfinal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="authors")
public class Author extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String  lastname,
                    firstname;

    @ManyToMany
    @JoinTable(name="bookauthors",
                joinColumns = {@JoinColumn(name="authorid")},
                inverseJoinColumns = {@JoinColumn(name = "bookid")}
              )
    @JsonIgnoreProperties("authors")
    private List<Book> books;

    public Author() {
    }

    public Author(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
