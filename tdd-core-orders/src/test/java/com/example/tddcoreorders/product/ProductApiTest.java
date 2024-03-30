package com.example.tddcoreorders.product;

import com.example.tddcoreorders.ApiTest;
import com.example.tddcoreorders.product.adapter.ProductRepository;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static com.example.tddcoreorders.product.ProductSteps.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductApiTest extends ApiTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void 상품등록(){
        final var request = 상품등록요청_생성();
        final var response = 상품등록요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회(){
        상품등록요청(상품등록요청_생성());
        Long productId = 1L;
        final var response = 상품조회요청(productId);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    ;}

    @Test
    void 상품수정() {

        상품등록요청(상품등록요청_생성());
        Long productId = 1L;

        final ExtractableResponse<Response> response = 상품수정요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(productRepository.findById(1L).get().getName()).isEqualTo("상품 수정");
    }

    private static ExtractableResponse<Response> 상품수정요청(Long productId) {
        return RestAssured.given().log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .body(ProductSteps.상품수정요청_생성())
                        .when()
                        .patch("/products/{productId}", productId)
                        .then().log().all()
                .extract();

    }
}
