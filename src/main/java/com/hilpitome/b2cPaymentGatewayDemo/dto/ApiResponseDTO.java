package com.hilpitome.b2cPaymentGatewayDemo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class ApiResponseDTO<T> {
    private T data;
    private String message;
    private int statusCode;
}
