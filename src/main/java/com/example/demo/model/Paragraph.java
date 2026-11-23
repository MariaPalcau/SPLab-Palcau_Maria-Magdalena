package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Paragraph extends BaseElement {
    private Long id;
    private String text;
    @Transient
    private AlignStrategy alignment;

    public Paragraph(String text){
        this.text = text;
        this.alignment = new AlignLeft();
    }

    @Override
    public void render(){
        alignment.render(this);
    }

    public String getText(){
        return text;
    }

    public void setAlignStrategy(AlignStrategy as){
        this.alignment = as;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}