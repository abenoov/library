package kz.iitu.mukhtar.library.controllers;

import kz.iitu.mukhtar.library.entity.Author;
import kz.iitu.mukhtar.library.services.AuthorService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class AuthorController {

    private Scanner sc = new Scanner(System.in);
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void showMenu(){
        System.out.println("1. Show all authors");
        System.out.println("2. Find author by name");
    }

    public void choice(int choice){
        switch (choice){
            case 1:
                showAllAuthors();
                break;
            case 2:
                getAuthorByName();
                break;
            default:
                System.out.println("No such choice");
                break;
        }
    }

    public void showAllAuthors(){
        authorService.showAllAuthors();
    }

    public Optional<Author> getAuthorById(){
        System.out.println("Enter author id: ");
        Long id = sc.nextLong();
        return authorService.getAuthorById(id);
    }

    public List<Author> getAuthorByName(){
        System.out.println("Enter author name: ");
        String name = sc.nextLine();
        return authorService.getAuthorByName(name);
    }


}