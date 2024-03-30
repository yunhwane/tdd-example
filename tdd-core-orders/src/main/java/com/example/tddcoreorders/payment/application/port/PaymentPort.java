package com.example.tddcoreorders.payment.application.port;


import com.example.tddcoreorders.order.domain.Order;
import com.example.tddcoreorders.payment.domain.Payment;

public interface PaymentPort {

    Order getOrder(final Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
