package com.example.tddcoreorders.payment.adapter;


import com.example.tddcoreorders.order.adapter.OrderRepository;
import com.example.tddcoreorders.order.domain.Order;
import com.example.tddcoreorders.payment.application.port.PaymentPort;
import com.example.tddcoreorders.payment.domain.Payment;
import org.springframework.stereotype.Component;


@Component
public class PaymentAdepter implements PaymentPort {

    private final PaymentGeteway paymentGateway;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentAdepter(final PaymentGeteway paymentGateway, final PaymentRepository paymentRepository, final OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public Order getOrder(final Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.excute(totalPrice, cardNumber);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }
}
