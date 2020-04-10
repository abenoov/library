package kz.iitu.mukhtar.library.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



    @OneToMany(mappedBy = "genere", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();;



    public Genre(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Genre(){

    }


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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
