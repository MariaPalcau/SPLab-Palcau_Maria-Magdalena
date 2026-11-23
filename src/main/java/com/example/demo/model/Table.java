package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@jakarta.persistence.Table(name = "E_TABLE")
public class Table extends BaseElement {
    private Long id;
    private String name;

    public Table(String name){
        this.name = name;
    }

    @Override
    public void render(){
        System.out.println(name);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}