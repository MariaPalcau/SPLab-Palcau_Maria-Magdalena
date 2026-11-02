package com.example.demo.controllers;
import com.example.demo.commands.*;
import com.example.demo.model.Book;
import com.example.demo.services.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    private BooksService bs;
    private Invoker inv;

    public BooksController(BooksService bs, Invoker i){
        this.bs = bs;
        this.inv = i;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> showBooks() {
        inv.setCommand(new GetBooksCommand(bs));
        inv.execute();
        return ResponseEntity.ok(bs.getAllBooks());
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> showBook(@PathVariable Long id) {
        Book book = bs.getBook(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }
    @PostMapping("/books")
    public ResponseEntity<Book> newBook(@RequestBody Book book) {
        inv.setCommand(new AddBookCommand(bs, book));
        inv.execute();
        return ResponseEntity.status(201).body(book);
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> modifyBook(@PathVariable Long id, @RequestBody Book book) {
        if (bs.getBook(id) == null) {
            return ResponseEntity.notFound().build();
        }
        inv.setCommand(new UpdateBookCommand(bs, id, book));
        inv.execute();
        return ResponseEntity.ok(bs.getBook(id));
    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bs.getBook(id) == null) {
            return ResponseEntity.notFound().build();
        }
        inv.setCommand(new DeleteBookCommand(bs, id));
        inv.execute();
        return ResponseEntity.noContent().build();
    }
}
