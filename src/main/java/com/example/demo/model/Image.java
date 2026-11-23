package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;

@Entity
@NoArgsConstructor
public class Image extends BaseElement {
    private String url;

    public Image(String url){
        this.url = url;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(){
        System.out.println(url);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}