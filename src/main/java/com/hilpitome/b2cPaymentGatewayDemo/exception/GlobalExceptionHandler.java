package com.hilpitome.b2cPaymentGatewayDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PaymentException.class)
    ResponseEntity<String>  handlePaymentException(PaymentException exception){
        return new ResponseEntity<>("Payment failed: "+exception.getMessage(), HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }


    @ExceptionHandler(SmsGatewayException.class)
    ResponseEntity<String>  handleSmsException(SmsGatewayException exception){
        return new ResponseEntity<>("Sending sms failed: "+exception.getMessage(), HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }


}
