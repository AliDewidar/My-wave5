package com.pioneers.serviceV3.util.pattern.factory.PaymentEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentFactory paymentFactory;


    /*
        ((without factory design pattern))
        1- code duplication
        2- hard-coded
        3- code and implementation are tightly coupled and in the same class

        @GetMapping("/process")
        public void getPayment(@RequestParam String type , @RequestParam double amount) {
            if (type.equalsIgnoreCase("credit card")) {
                CreditCard creditCard = new CreditCard();
                creditCard.processPayment(amount);
            } else if (type.equalsIgnoreCase("paypal")) {
                PayPal payPal = new PayPal();
                payPal.processPayment(amount);
            } else if (type.equalsIgnoreCase("bitcoin")) {
                Bitcoin bitcoin = new Bitcoin();
                bitcoin.processPayment(amount);
            } else {
                throw new IllegalArgumentException("Invalid payment type: " + type);
            }
        }
    */

    public void getPayment(@RequestParam String type , @RequestParam double amount) {
        paymentFactory.getPayment(type).processPayment(amount);
    }
}
