package com.example.tddcoreorders.order.adapter;


import com.example.tddcoreorders.order.application.port.OrderPort;
import com.example.tddcoreorders.order.domain.Order;
import com.example.tddcoreorders.product.adapter.ProductRepository;
import com.example.tddcoreorders.product.domain.Product;
import org.springframework.stereotype.Component;


@Component
class OrderAdepter implements OrderPort {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderAdepter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Product getProductById(final Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    public void save(final Order order) {
        orderRepository.save(order);
    }
}
