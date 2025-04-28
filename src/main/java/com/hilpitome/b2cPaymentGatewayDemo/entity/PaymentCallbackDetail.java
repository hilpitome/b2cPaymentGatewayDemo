package com.hilpitome.b2cPaymentGatewayDemo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_callback_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentCallbackDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    private boolean success;
    private String transactionId;
    private String message;
}
