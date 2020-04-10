package kz.iitu.mukhtar.library.controllers;


import kz.iitu.mukhtar.library.entity.Author;
import kz.iitu.mukhtar.library.entity.Book;
import kz.iitu.mukhtar.library.entity.Genre;
import kz.iitu.mukhtar.library.services.BookService;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class BookController {

    private Scanner sc = new Scanner(System.in);


    private final BookService bookService;
    private final AuthorController authorController;

    public BookController(BookService bookService, AuthorController authorController) {
        this.bookService = bookService;
        this.authorController = authorController;
    }

    public void showMenu(){
        System.out.println("1. Show all books");
        System.out.println("3. Find book");
    }

    public void choice(int choice){
        switch (choice){
            case 1:
                showAllBooks();
                break;
            case 2:
                findBook();
                break;
            default:
                System.out.println("No such choice");
                break;
        }
    }

    public void showAllBooks(){
        bookService.showAllBooks();
    }


    public Book findBookById(){
        System.out.println("Enter book ID: ");
        Long id = sc.nextLong();
        return bookService.findBookById(id).orElse(null);
    }

    public void findBook(){
        System.out.println("Look in book by name or description");
        String search = sc.nextLine();
        search = search.toLowerCase();
        bookService.findBook(search);
    }

}