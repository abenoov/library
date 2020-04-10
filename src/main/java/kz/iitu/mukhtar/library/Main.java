package kz.iitu.mukhtar.library;

import kz.iitu.mukhtar.library.config.SpringConfiguration;
import kz.iitu.mukhtar.library.controllers.AuthorController;
import kz.iitu.mukhtar.library.controllers.BookController;
import kz.iitu.mukhtar.library.controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);


        AuthorController authorController = context.getBean("authorController", AuthorController.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        UserController userController = context.getBean("userController", UserController.class);

        System.out.println("1) author settings");
        System.out.println("2) book settings");
        System.out.println("3) user settings");

        int choice = sc.nextInt();

        if (choice == 1) {
            authorController.showMenu();
            authorController.choice(sc.nextInt());
        } else if (choice == 2) {
            bookController.showMenu();
            bookController.choice(sc.nextInt());
        } else if (choice == 3) {
            userController.showMenu();
            userController.choice(sc.nextInt());
        }
    }
}
