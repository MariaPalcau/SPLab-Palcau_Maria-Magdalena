package com.example.demo.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Book extends Section{
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Author> authors = new ArrayList<>();

    public Book(String title){
        super(title);
    }

    public void render(){
        super.render();
        System.out.println("Authors: ");
        for (Author a: authors) {
            a.print();
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
        for (Element e: getElements()) {
            e.accept(v);
        }
    }

    public void addAuthor(Author a){
        authors.add(a);
    }

    public List<Author> getAuthors(){
        return authors;
    }
}