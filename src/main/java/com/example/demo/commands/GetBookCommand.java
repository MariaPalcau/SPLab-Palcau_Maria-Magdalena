package com.example.demo.commands;

import com.example.demo.services.BooksService;

public class GetBookCommand implements Command {
    private BooksService bs;
    private Long id;

    public GetBookCommand(BooksService bs, Long id){
        this.bs = bs;
        this.id = id;
    }
    @Override
    public void execute(){
        bs.getBook(id);
    }
}
