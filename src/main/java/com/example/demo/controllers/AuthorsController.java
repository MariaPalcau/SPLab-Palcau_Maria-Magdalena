package com.example.demo.controllers;

import com.example.demo.commands.*;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.persistence.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    private CommandContext context;
    private Invoker inv;

    public AuthorsController(CommandContext context, Invoker i){
        this.context = context;
        this.inv = i;
    }

    @GetMapping
    public ResponseEntity<List<Author>> showAuthors() {
        GetAuthorsCommand command = new GetAuthorsCommand(context);
        inv.setCommand(command);
        inv.execute();
        return ResponseEntity.ok(command.getAuthors());
    }
}
