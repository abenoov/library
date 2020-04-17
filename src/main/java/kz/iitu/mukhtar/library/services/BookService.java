package kz.iitu.mukhtar.library.services;

import kz.iitu.mukhtar.library.entity.Book;
import kz.iitu.mukhtar.library.repository.BookRepository;
import kz.iitu.mukhtar.library.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public List<Book> showAllBooks(){
      return bookRepository.findAll();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> findBook(String search){
        return bookRepository.findAllByTitleIsContainingOrDescriptionContaining(search);
    }

    public Optional<Book> findBookById(Long id){
        return bookRepository.findById(id);
    }

}
