package com.pioneers.patterns.patterns.chainofresponsibility;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chainOfResponsibility")
public class ChainOfResponsibilityController {

    @NonNull
    private final FirstLineHandler firstLineHandler;
    private final SecondLineHandler secondLineHandler;
    private final Development development;

    public ChainOfResponsibilityController(@NonNull FirstLineHandler firstLineHandler,
                                           @NonNull SecondLineHandler secondLineHandler,
                                           @NonNull Development development) {
        this.firstLineHandler = firstLineHandler;
        this.secondLineHandler = secondLineHandler;
        this.development = development;
    }


    @PostConstruct
    public void buildChain() {
        firstLineHandler.setNextHandler(secondLineHandler);
        secondLineHandler.setNextHandler(development);
    }

    @RequestMapping("solveIssue/{request}")
    public void resolveIssueApi(@PathVariable String request) {
        firstLineHandler.handleRequest(request);
    }

}
