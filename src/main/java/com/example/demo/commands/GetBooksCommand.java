package com.example.demo.commands;

import com.example.demo.services.BooksService;

public class GetBooksCommand implements Command {
    private BooksService bs;
    public GetBooksCommand(BooksService bs){
        this.bs = bs;
    }
    @Override
    public void execute(){
        bs.getAllBooks();
    }
}
