package com.example.demo.commands;

import com.example.demo.model.Author;

import java.util.List;

public class GetAuthorsCommand implements Command {

    private final CommandContext context;
    private List<Author> authors;

    public GetAuthorsCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        authors = context.getAuthorsRepository().findAll();
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
