package com.example.demo.model;

import jakarta.persistence.Inheritance;

@Inheritance
public class BaseElement implements Element{
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
