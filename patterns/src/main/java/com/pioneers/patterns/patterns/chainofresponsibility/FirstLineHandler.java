package com.pioneers.patterns.patterns.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FirstLineHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("First Line")) {
           log.info("First line is fixing the issue...");
           log.info("Successfully fixed the issue by the first line team");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            throw new RuntimeException("Next handler is null");
        }
    }
}
