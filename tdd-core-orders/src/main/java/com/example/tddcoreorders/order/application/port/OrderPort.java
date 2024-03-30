package com.example.tddcoreorders.order.application.port;


import com.example.tddcoreorders.order.domain.Order;
import com.example.tddcoreorders.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public interface OrderPort {
    Product getProductById(final Long productId);

    void save(final Order order);
}
