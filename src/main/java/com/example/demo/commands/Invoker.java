package com.example.demo.commands;

import org.springframework.stereotype.Component;

@Component
public class Invoker {
    private Command c;

    public void setCommand(Command c){
        this.c = c;
    }

    public void execute(){
        if (c != null){
            c.execute();
        }
    }
}
