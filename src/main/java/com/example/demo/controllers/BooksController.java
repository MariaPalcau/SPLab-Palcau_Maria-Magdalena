package com.example.demo.controllers;
import com.example.demo.commands.*;
import com.example.demo.model.Book;
import com.example.demo.persistence.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final CommandContext context;
    private Invoker inv;

    public BooksController(CommandContext context, Invoker i){
        this.context = context;
        this.inv = i;
    }

    @GetMapping
    public ResponseEntity<List<Book>> showBooks() {
        GetBooksCommand command = new GetBooksCommand(context);
        inv.setCommand(command);
        inv.execute();
        return ResponseEntity.ok(command.getBooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> showBook(@PathVariable Long id) {
        GetBookCommand command = new GetBookCommand(context, id);
        inv.setCommand(command);
        inv.execute();
        Optional<Book> book = command.getBook();
        if (book.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        AddBookCommand command = new AddBookCommand(context, book);
        inv.setCommand(command);
        inv.execute();
        return ResponseEntity.status(201).body(command.getCreatedBook());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> modifyBook(@PathVariable Long id, @RequestBody Book book) {
        UpdateBookCommand command = new UpdateBookCommand(context, id, book);
        inv.setCommand(command);
        inv.execute();
        return command.getUpdatedBook()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        DeleteBookCommand command = new DeleteBookCommand(context, id);
        inv.setCommand(command);
        inv.execute();
        if (!command.isDeleted()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
