package com.hilpitome.b2cPaymentGatewayDemo.dto;

public class ApiResponseDTO<T> {
    private T data;
    private String message;
    private int statusCode;
}
