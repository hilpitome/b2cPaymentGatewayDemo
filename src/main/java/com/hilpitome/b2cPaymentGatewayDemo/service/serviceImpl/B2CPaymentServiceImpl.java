package com.hilpitome.b2cPaymentGatewayDemo.service.serviceImpl;

import com.hilpitome.b2cPaymentGatewayDemo.entity.PaymentRequestLog;
import com.hilpitome.b2cPaymentGatewayDemo.service.B2CPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class B2CPaymentServiceImpl implements B2CPaymentService {
    @Override
    @Async
    public void sendMoney(PaymentRequestLog paymentRequestLog) {
        // mock payment
        log.info("Sending money for {}", paymentRequestLog.toString());
    }
}
