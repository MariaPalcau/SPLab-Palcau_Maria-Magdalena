package com.example.demo.services;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BooksService {
    private Map<Long, Book> books = new HashMap<>();
    private Long nextId = 1L;

    public List<Book> getAllBooks(){
        return new ArrayList<>(books.values());
    }

    public Book getBook(Long id){
        return books.get(id);
    }

    public Book createBook(Book b){
        b.setId(nextId);
        nextId++;
        books.put(b.getId(), b);
        return b;
    }

    public Book updateBook(Long id, Book updatedBook) {
        if (!books.containsKey(id)) {
            return null;
        }
        updatedBook.setId(id);
        books.put(id, updatedBook);
        return updatedBook;
    }

    public boolean deleteBook(Long id) {
        return books.remove(id) != null;
    }
}
