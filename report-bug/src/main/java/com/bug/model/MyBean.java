package com.bug.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    @Getter
    @Setter
    private String daj = "lol";
    public void say(){
        System.out.println("hey");
    }
}
