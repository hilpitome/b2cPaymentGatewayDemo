package com.hilpitome.b2cPaymentGatewayDemo.exception;

public class PaymentException extends RuntimeException {
    public PaymentException(String message){
        super(message);
    }
}
