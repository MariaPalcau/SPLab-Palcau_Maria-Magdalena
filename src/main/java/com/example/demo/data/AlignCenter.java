package com.example.demo.data;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph p){
        System.out.println("    " + p.getText());
    }
}
