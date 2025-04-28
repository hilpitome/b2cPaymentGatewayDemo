package com.hilpitome.b2cPaymentGatewayDemo.dto;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponseDTO<T> {
    String message;
}
