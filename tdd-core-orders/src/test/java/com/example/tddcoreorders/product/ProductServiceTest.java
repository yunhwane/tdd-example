package com.example.tddcoreorders.product;


import com.example.tddcoreorders.product.application.port.ProductPort;
import com.example.tddcoreorders.product.application.service.GetProductResponse;
import com.example.tddcoreorders.product.application.service.ProductService;
import com.example.tddcoreorders.product.application.service.UpdateProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static com.example.tddcoreorders.product.ProductSteps.상품수정요청_생성;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductPort productPort;



    @Test
    void 상품수정(){
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;
        final UpdateProductRequest request = 상품수정요청_생성();

        productService.updateProduct(productId,request);

        final ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        final GetProductResponse productResponse = response.getBody();

        assertThat(productResponse.name()).isEqualTo("상품 수정");
        assertThat(productResponse.price()).isEqualTo(2000);
    }



}
