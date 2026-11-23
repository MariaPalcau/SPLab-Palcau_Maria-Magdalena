package com.example.demo.model;

import java.io.IOException;

public interface Observer {
    void update(Book b) throws IOException;
}
