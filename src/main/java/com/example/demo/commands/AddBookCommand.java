package com.example.demo.commands;

import com.example.demo.model.Book;
import com.example.demo.persistence.BooksRepository;
import com.example.demo.services.BooksService;

public class AddBookCommand implements Command{
    private final CommandContext context;
    private final Book book;
    private Book createdBook;

    public AddBookCommand(CommandContext context, Book book) {
        this.context = context;
        this.book = book;
    }

    @Override
    public void execute() {
        createdBook = context.getBooksRepository().save(book);
    }

    public Book getCreatedBook() {
        return createdBook;
    }
}
