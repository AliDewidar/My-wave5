package com.pioneers.spring.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spellCheck")
public class SpellCheckerController {

    private SpellChecker spellChecker;

//    public SpellCheckerController(SpellChecker spellChecker) {
//        this.spellChecker = spellChecker;
//    }

    @Autowired
    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    @GetMapping("changeText")
    public void changeText() {
        spellChecker.changeText("Welcome to tech pioneers hub !");
    }

    @GetMapping("showText")
    public String showText() {
        return spellChecker.showText();
    }

}
