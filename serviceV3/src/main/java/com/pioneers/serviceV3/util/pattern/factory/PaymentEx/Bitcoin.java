package com.pioneers.serviceV3.util.pattern.factory.PaymentEx;

public class Bitcoin implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bitcoin payment: " + amount);
    }
}
