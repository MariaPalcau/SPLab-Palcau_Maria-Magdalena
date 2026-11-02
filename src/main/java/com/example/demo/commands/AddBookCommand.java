package com.example.demo.commands;

import com.example.demo.model.Book;
import com.example.demo.services.BooksService;

public class AddBookCommand implements Command{
    private BooksService bs;
    private Book b;

    public AddBookCommand(BooksService bs, Book b){
        this.bs = bs;
        this.b = b;
    }
    @Override
    public void execute(){
        bs.createBook(b);
    }
}
