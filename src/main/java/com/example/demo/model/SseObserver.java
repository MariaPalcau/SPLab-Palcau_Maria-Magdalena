package com.example.demo.model;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class SseObserver implements Observer {
    private SseEmitter emitter;

    public SseObserver(SseEmitter emitter){
        this.emitter = emitter;
    }
    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
