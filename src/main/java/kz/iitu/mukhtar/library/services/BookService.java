package kz.iitu.mukhtar.library.services;

import kz.iitu.mukhtar.library.entity.Book;
import kz.iitu.mukhtar.library.repository.BookRepository;
import kz.iitu.mukhtar.library.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public void showAllBooks(){
        for (Book book: bookRepository.findAll()){
            System.out.println(book.toString());
        }
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void findBook(String search){
        for (Book book: bookRepository.findAllByTitleIsContainingOrDescriptionContaining(search)){
            System.out.println(book.toString());
        }
    }

    public Optional<Book> findBookById(Long id){
        return bookRepository.findById(id);
    }

}
