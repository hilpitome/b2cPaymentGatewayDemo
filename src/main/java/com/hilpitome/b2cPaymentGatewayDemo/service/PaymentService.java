package com.hilpitome.b2cPaymentGatewayDemo.service;

import com.hilpitome.b2cPaymentGatewayDemo.dto.ApiResponseDTO;
import com.hilpitome.b2cPaymentGatewayDemo.dto.PaymentRequestDTO;
import com.hilpitome.b2cPaymentGatewayDemo.dto.PaymentResponseDTO;
import com.hilpitome.b2cPaymentGatewayDemo.entity.PaymentRequestLog;

public interface PaymentService {
    ApiResponseDTO<PaymentResponseDTO<String>> makePayment(PaymentRequestLog paymentDetails);
}
