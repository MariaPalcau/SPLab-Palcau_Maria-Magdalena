package com.example.demo.commands;

import com.example.demo.model.Book;

import java.util.List;

public class GetBooksCommand implements Command {

    private final CommandContext context;
    private List<Book> books;

    public GetBooksCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        books = context.getBooksRepository().findAll();
    }

    public List<Book> getBooks() {
        return books;
    }
}
