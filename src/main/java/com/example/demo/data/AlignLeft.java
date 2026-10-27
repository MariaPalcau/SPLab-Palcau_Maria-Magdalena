package com.example.demo.data;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph p){
        System.out.println(p.getText());
    }
}
