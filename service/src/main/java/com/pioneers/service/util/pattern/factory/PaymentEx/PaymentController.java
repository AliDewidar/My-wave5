package com.pioneers.service.util.pattern.factory.PaymentEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentFactory paymentFactory;

    public void getPayment(@RequestParam String type , @RequestParam double amount) {
        paymentFactory.getPayment(type).processPayment(amount);
    }
}
