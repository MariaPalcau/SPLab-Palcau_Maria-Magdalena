package com.example.demo.commands;

import com.example.demo.model.Book;
import com.example.demo.services.BooksService;

import java.util.Optional;

public class DeleteBookCommand implements Command {
    private CommandContext c;
    private Long id;
    private boolean deleted;

    public DeleteBookCommand(CommandContext c, Long id){
        this.c = c;
        this.id = id;
    }
    @Override
    public void execute(){
        Optional<Book> result = c.getBooksRepository().findById(id);
        if (result.isPresent()) {
            c.getBooksRepository().deleteById(id);
            deleted = true;
        }
    }

    public boolean isDeleted(){
        return deleted;
    }
}
