package com.example.tddcoreorders.payment;


import com.example.tddcoreorders.ApiTest;
import com.example.tddcoreorders.order.OrderSteps;
import com.example.tddcoreorders.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.example.tddcoreorders.payment.PaymentSteps.주문결제요청;
import static com.example.tddcoreorders.payment.PaymentSteps.주문결제요청_생성;
import static org.assertj.core.api.Assertions.assertThat;


public class PaymentApiTest extends ApiTest {


    @Test
    void 상품주문() {


        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());
        final var request = 주문결제요청_생성();
        final var response = 주문결제요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
