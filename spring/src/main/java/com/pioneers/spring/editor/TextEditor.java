package com.pioneers.spring.editor;

import org.springframework.stereotype.Component;

@Component
public class TextEditor {
    private String text = "Hello World !";

    public TextEditor() {
        System.out.println("Initializing TextEditor ...");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
