package com.example.demo.model;

public class Author {
    private Long id;
    private String name;
    private String surname;

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public void print(){
        System.out.println("Author: " + name + " " + surname);
    }
}