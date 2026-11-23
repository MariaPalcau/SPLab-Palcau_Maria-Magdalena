package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TableOfContents extends BaseElement {
    private Long id;
    private String content;

    public TableOfContents(String content){
        this.content = content;
    }
    @Override
    public void render(){
        System.out.println("Table of Contents: ");
        System.out.println(content);
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}