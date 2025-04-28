package com.hilpitome.b2cPaymentGatewayDemo.dto;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequestDTO {
    private double amount;
    private String sender;
    private String receiver;
}
