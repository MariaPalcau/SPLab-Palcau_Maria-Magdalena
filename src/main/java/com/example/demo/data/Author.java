package com.example.demo.data;

public class Author {
    private String name;
    private String surname;

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public void print(){
        System.out.println("com.example.demo.data.Author: " + name + " " + surname);
    }
}