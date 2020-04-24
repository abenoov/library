package kz.iitu.mukhtar.library.services;


import kz.iitu.mukhtar.library.entity.Book;
import kz.iitu.mukhtar.library.entity.User;
import kz.iitu.mukhtar.library.repository.BookRepository;
import kz.iitu.mukhtar.library.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public UserService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public void issueBook(User user, Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            user.setBook(book);
            userRepository.save(user);
            bookRepository.save(book);
        } else {
            System.out.println("The book is not available");
        }
    }

    public void returnBook(User user, Book book) {
        if (book.isAvailable() == false) {
            user.setBook(null);
            userRepository.save(user);
            book.setAvailable(true);
            bookRepository.save(book);
        } else {
            System.out.println("Book is not available");
        }
    }


    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("User with username: " + username + " is not found");

        return user;
    }
}
