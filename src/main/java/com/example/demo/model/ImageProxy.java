package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class ImageProxy extends BaseElement {
    private String url;
    @Transient
    private Image realImage;

    public ImageProxy(String url){
        this.url = url;
        this.realImage = null;
    }

    private Image loadImage(){
        if(realImage == null){
            realImage = new Image(url);
        }
        return realImage;
    }

    @Override
    public void render(){
        loadImage().render();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
