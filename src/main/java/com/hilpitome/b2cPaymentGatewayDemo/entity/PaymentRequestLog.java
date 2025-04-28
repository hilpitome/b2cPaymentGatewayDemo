package com.hilpitome.b2cPaymentGatewayDemo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_request_logs")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class PaymentRequestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    private Double amount;
    private String sender;
    private String receiver;
}
