package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class allBooksSubject implements Subject {
    private List<Observer> observers = new CopyOnWriteArrayList<>();
    private volatile Book lastBook;

    public void add(Book book) {
        this.lastBook = book;
        notifyObservers();
    }

    public Book getLastBook() {
        return lastBook;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Book book = lastBook;
        for (Observer observer : observers) {
            try{
                observer.update(book);
            } catch (IOException | IllegalStateException e) {
                e.printStackTrace();
                unregisterObserver(observer);
            }
        }
    }
}