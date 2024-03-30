package com.example.tddcoreorders.product.adapter;

import com.example.tddcoreorders.product.application.port.ProductPort;
import com.example.tddcoreorders.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(final long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지않습니다."));
    }
}
