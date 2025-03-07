package com.pioneers.serviceV2.util.pattern.factory.PaymentEx;

import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {
    public Payment getPayment(String type) {
        return switch (type.toLowerCase()) {
            case "credit card" -> new CreditCard();
            case "paypal" -> new PayPal();
            case "bitcoin" -> new Bitcoin();
            default -> throw new IllegalArgumentException("Invalid payment type: " + type);
        };
    }
}
