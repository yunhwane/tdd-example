package com.example.tddcoreorders.order;


import com.example.tddcoreorders.order.domain.Order;
import com.example.tddcoreorders.product.domain.DiscountPolicy;
import com.example.tddcoreorders.product.domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPrice() {
        final Order order = new Order(new Product("상품명", 10000, DiscountPolicy.Fix_1000_AMOUNT),2);
        final int totalPrice = order.getTotalPrice();

        assertEquals(18000, totalPrice);
    }
}