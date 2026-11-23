package com.example.demo.commands;

import com.example.demo.model.Book;
import com.example.demo.services.BooksService;

import java.util.Optional;

public class UpdateBookCommand implements Command {
    private final CommandContext context;
    private final Long id;
    private final Book newData;
    private Book result;

    public UpdateBookCommand(CommandContext context, Long id, Book newData) {
        this.context = context;
        this.id = id;
        this.newData = newData;
    }

    @Override
    public void execute() {
        if (context.getBooksRepository().findById(id).isPresent()) {
            newData.setId(id);
            result = context.getBooksRepository().save(newData);
        }
    }

    public Optional<Book> getUpdatedBook() {
        return Optional.ofNullable(result);
    }
}
