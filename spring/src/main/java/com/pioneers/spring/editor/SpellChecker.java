package com.pioneers.spring.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpellChecker {

    private final TextEditor textEditor;

    @Autowired
    public SpellChecker(TextEditor textEditor) {
        this.textEditor = textEditor;
        System.out.println("Initializing SpellChecker...");
    }

    public void changeText(final String text) {
        this.textEditor.setText(text);
    }

    public String showText() {
        return this.textEditor.getText();
    }


}
