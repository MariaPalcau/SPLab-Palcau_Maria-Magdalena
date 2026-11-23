package com.example.demo.commands;

import com.example.demo.model.Book;

import java.util.Optional;

public class GetBookCommand implements Command {
    private CommandContext c;
    private Optional<Book> book;
    private Long id;

    public GetBookCommand(CommandContext c, Long id){
        this.c = c;
        this.id = id;
    }
    @Override
    public void execute(){
        book = c.getBooksRepository().findById(id);
    }

    public Optional<Book> getBook(){
        return book;
    }
}
