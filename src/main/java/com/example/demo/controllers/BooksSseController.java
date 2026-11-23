package com.example.demo.controllers;

import com.example.demo.model.Observer;
import com.example.demo.model.SseObserver;
import com.example.demo.model.allBooksSubject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class BooksSseController {
    private allBooksSubject abs;

    public BooksSseController(allBooksSubject abs) {
        this.abs = abs;
    }

    @GetMapping("/books-sse")
    public ResponseBodyEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);
        Observer observer = new SseObserver(emitter);
        abs.registerObserver(observer);
        return emitter;
    }
}
