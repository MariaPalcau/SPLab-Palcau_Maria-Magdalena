package com.example.demo.commands;

import com.example.demo.services.BooksService;

public class DeleteBookCommand implements Command {
    private BooksService bs;
    private Long id;
    public DeleteBookCommand(BooksService bs, Long id){
        this.bs = bs;
        this.id = id;
    }
    @Override
    public void execute(){
        bs.deleteBook(id);
    }
}
