package com.pioneers.patterns.patterns.chainofresponsibility;

public interface Handler {
    void setNextHandler(Handler nextHandler);
    void handleRequest(String request);
}
