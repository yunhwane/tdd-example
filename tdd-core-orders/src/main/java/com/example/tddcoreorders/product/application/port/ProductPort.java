package com.example.tddcoreorders.product.application.port;


import com.example.tddcoreorders.product.domain.Product;

public interface ProductPort {
    void save(final Product product);
    Product getProduct(final long productId);
}
