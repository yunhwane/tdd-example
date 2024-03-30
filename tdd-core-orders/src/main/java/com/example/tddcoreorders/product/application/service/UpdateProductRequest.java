package com.example.tddcoreorders.product.application.service;


import com.example.tddcoreorders.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    public UpdateProductRequest {
        Assert.hasText(name, "상품명은 필수 입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인정책은 필수 입니다.");

    }
}
