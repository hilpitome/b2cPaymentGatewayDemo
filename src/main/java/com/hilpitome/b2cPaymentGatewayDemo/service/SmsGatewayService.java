package com.hilpitome.b2cPaymentGatewayDemo.service;

import com.hilpitome.b2cPaymentGatewayDemo.entity.PaymentRequestLog;

public interface SmsGatewayService {
    void sendMessage(String message);
}

