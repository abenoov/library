package kz.iitu.mukhtar.library.services;

import kz.iitu.mukhtar.library.entity.Author;
import kz.iitu.mukhtar.library.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> showAllAuthors(){
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id){
        return authorRepository.findById(id);
    }

    public List<Author> getAuthorByName(String name){
        return authorRepository.findAuthorByNameContains(name);
    }

}
