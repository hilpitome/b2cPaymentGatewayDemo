package com.hilpitome.b2cPaymentGatewayDemo.service;

import com.hilpitome.b2cPaymentGatewayDemo.entity.PaymentRequestLog;

public interface B2CPaymentService {
    void sendMoney(PaymentRequestLog paymentRequestLog);
}
