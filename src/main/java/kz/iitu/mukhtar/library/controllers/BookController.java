package kz.iitu.mukhtar.library.controllers;


import kz.iitu.mukhtar.library.entity.Author;
import kz.iitu.mukhtar.library.entity.Book;
import kz.iitu.mukhtar.library.entity.Genre;
import kz.iitu.mukhtar.library.services.BookService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorController authorController;

    public BookController(BookService bookService, AuthorController authorController) {
        this.bookService = bookService;
        this.authorController = authorController;
    }

    @GetMapping("")
    public List<Book> showAllBooks(){
        return bookService.showAllBooks();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id){
        return bookService.findBookById(id).orElse(null);
    }

    @GetMapping("/find/")
    public List<Book> findBook(@RequestParam("search") String search){
        search = search.toLowerCase();
        return bookService.findBook(search);
    }

}