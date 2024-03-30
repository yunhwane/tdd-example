package com.example.tddcoreorders.payment;


import com.example.tddcoreorders.payment.application.service.PaymentRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class PaymentSteps {

    public static PaymentRequest 주문결제요청_생성() {
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        return new PaymentRequest(orderId,cardNumber);
    }

    static ExtractableResponse<Response> 주문결제요청(PaymentRequest request) {
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request).when()
                .post("/payments")
                .then().log().all().extract();
        return response;
    }
}
