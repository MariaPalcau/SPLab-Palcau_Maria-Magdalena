package com.example.demo.controllers;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {
    @GetMapping("/books")
    public String showBooks() {
        return "Books";
    }
    @GetMapping("/books/{id}")
    public String showBook() {
        return "Book {id}";
    }
    @PostMapping("/books")
    public String newBook() {
        return "New book";
    }
    @PutMapping("/books/{id}")
    public String modifyBook() {
        return "Modified Book {id}";
    }
    @DeleteMapping("/books/{id}")
    public String deleteBook() {
        return "Deleted Book {id}";
    }
}
