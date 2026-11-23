package com.example.demo.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Section extends BaseElement {
    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<BaseElement> elements = new ArrayList<>();

    public Section(String title){
        this.title = title;
    }

    @Override
    public void render(){
        System.out.println(title);
    }

    @Override
    public void add(Element e){
        elements.add( (BaseElement) e);
    }

    @Override
    public void remove(Element e){
        elements.remove(e);
    }

    @Override
    public Element get(int index){
        return elements.get(index);
    }

    public List<BaseElement> getElements() {
        return elements;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
        for (Element e: elements) {
            e.accept(v);
        }
    }
}