package kz.iitu.mukhtar.library.controllers;

import io.swagger.annotations.ApiOperation;
import kz.iitu.mukhtar.library.entity.Author;
import kz.iitu.mukhtar.library.entity.Book;
import kz.iitu.mukhtar.library.entity.User;
import kz.iitu.mukhtar.library.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final BookController bookController;


    public UserController(UserService userService, BookController bookController) {
        this.userService = userService;
        this.bookController = bookController;
    }

    @ApiOperation(value = "Returns all users in the database", response = List.class)
    @GetMapping("")
    public List<User> shooAllUsers(){
        return userService.showAllUsers();
    }

    @ApiOperation(value = "Returns user by id", response = User.class)
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id){
        return userService.findUserById(id).orElse(null);
    }

    @ApiOperation(value = "Issue book to a user")
    @PostMapping("/issue/")
    public void issueBook(@RequestParam("user_id") Long userId,@RequestParam("book_id") Long bookId){
        User user = findUserById(userId);
        Book book = bookController.findBookById(bookId);
        userService.issueBook(user, book);
    }

    @ApiOperation(value = "Return book")
    @PostMapping("/return/")
    public void returnTheBook(@RequestParam("user_id") Long userId,@RequestParam("book_id") Long bookId){
        User user = findUserById(userId);
        Book book = bookController.findBookById(bookId);
        userService.returnBook(user, book);
    }

}
