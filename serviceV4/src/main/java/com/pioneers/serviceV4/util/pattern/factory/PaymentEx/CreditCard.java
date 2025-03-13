package com.pioneers.serviceV4.util.pattern.factory.PaymentEx;

public class CreditCard implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment: " + amount);
    }
}
