package pl.bykowski.Books.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @OneToMany
    @JoinColumn(name = "author_id") // znajomości podstaw springa jpa to troche zaawansowne rzeczy
    private Set<Book> bookSet;

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public Author() {
    }
// niechailo mu utworzyć paramerowego konstruktora
  //  public Author(Long id, String name, String surname) {
  //      this.id = id;
  //     this.name = name;
  //      this.surname = surname;
   // }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
