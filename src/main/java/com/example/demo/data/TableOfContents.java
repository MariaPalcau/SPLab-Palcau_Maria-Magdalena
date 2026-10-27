package com.example.demo.data;

public class TableOfContents implements Element {
    private String content;

    public TableOfContents(String content){
        this.content = content;
    }
    @Override
    public void render(){
        System.out.println("com.example.demo.data.Table of Contents: ");
        System.out.println(content);
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}