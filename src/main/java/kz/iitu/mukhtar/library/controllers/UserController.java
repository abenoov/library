package kz.iitu.mukhtar.library.controllers;

import kz.iitu.mukhtar.library.entity.Book;
import kz.iitu.mukhtar.library.entity.User;
import kz.iitu.mukhtar.library.services.UserService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserController {

    private Scanner in = new Scanner(System.in);
    //Services
    private final UserService userService;

    //Controllers
    private final BookController bookController;


    public UserController(UserService userService, BookController bookController) {
        this.userService = userService;
        this.bookController = bookController;
    }

    public void showMenu(){
        System.out.println("1. Issue book");
        System.out.println("2. Show all users");
        System.out.println("3. Return book");
    }

    public void choice(int choice){
        switch (choice){
            case 1:
                issueBook();
                break;
            case 2:
                shooAllUsers();
                break;
            case 3:
                returnTheBook();
                break;
            default:
                System.out.println("No such choice");
                break;
        }
    }

    public void shooAllUsers(){
        userService.showAllUsers();
    }

    public User findUserById(){
        System.out.println("Enter user ID: ");
        Long id = in.nextLong();
        return userService.findUserById(id).orElse(null);
    }

    public void issueBook(){
        User user = findUserById();
        Book book = bookController.findBookById();
        userService.issueBook(user, book);
    }

    public void returnTheBook(){
        User user = findUserById();
        Book book = bookController.findBookById();
        userService.returnBook(user, book);
    }

}
