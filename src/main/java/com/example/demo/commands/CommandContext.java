package com.example.demo.commands;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.persistence.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class CommandContext {
    private final CrudRepository<Book, Long> booksRepository;
    private final CrudRepository<Author, Long> authorsRepository;

    public CommandContext(CrudRepository<Book, Long> booksRepository, CrudRepository<Author, Long> authorsRepository) {
        this.booksRepository = booksRepository;
        this.authorsRepository = authorsRepository;
    }

    public CrudRepository<Book, Long> getBooksRepository() {
        return booksRepository;
    }

    public CrudRepository<Author, Long> getAuthorsRepository() {
        return authorsRepository;
    }
}
