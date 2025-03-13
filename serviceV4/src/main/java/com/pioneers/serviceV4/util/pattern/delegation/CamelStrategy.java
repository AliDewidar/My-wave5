package com.pioneers.serviceV4.util.pattern.delegation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("camel") // rename this bean from CamelStrategy to camel
public class CamelStrategy implements Animal {
    @Override
    public boolean isBird() {
        return false;
    }

    @Override
    public void eat() {
        log.info("Feeding camel...");
    }

    @Override
    public void drink() {
        log.info("Drinking camel...");
    }

    @Override
    public void makeSound() {
        log.info("Camel is making sound...");
    }

    @Override
    public void make2e2h() {
        log.info("Dodo y 2amar y abo tota 3ryana, 3'teha y 2amar de 3leha debana, 3'teha w 25te4i da lonha me4me4i...");
    }
}
