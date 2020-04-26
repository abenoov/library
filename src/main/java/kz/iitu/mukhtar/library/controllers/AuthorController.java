package kz.iitu.mukhtar.library.controllers;

import io.swagger.annotations.ApiOperation;
import kz.iitu.mukhtar.library.entity.Author;
import kz.iitu.mukhtar.library.services.AuthorService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ApiOperation(value = "Returns all authors in the database", response = List.class)
    @GetMapping("")
    public List<Author> showAllAuthors(){
        return authorService.showAllAuthors();
    }

    @ApiOperation(value = "Returns authors by id", response = Author.class)
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") Long id){
        return authorService.getAuthorById(id).get();
    }

    @ApiOperation(value = "Search authors", response = List.class)
    @GetMapping("/find/")
    public List<Author> getAuthorByName(@RequestParam("name") String name){
        return authorService.getAuthorByName(name);
    }


}