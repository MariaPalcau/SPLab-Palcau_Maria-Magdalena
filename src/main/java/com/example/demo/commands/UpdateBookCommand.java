package com.example.demo.commands;

import com.example.demo.model.Book;
import com.example.demo.services.BooksService;

public class UpdateBookCommand implements Command {
    private BooksService bs;
    private Long id;
    private Book b;
    public UpdateBookCommand(BooksService bs, Long id, Book b){
        this.bs = bs;
        this.id = id;
        this.b = b;
    }
    @Override
    public void execute(){
        bs.updateBook(id, b);
    }
}
