package com.hilpitome.b2cPaymentGatewayDemo.service.serviceImpl;

import com.hilpitome.b2cPaymentGatewayDemo.service.SmsGatewayService;
import com.sun.source.doctree.IndexTree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsGatewayServiceImpl implements SmsGatewayService {
    @Async
    @Override
    public void sendMessage(String message) {
        // mock
        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException ex){
            log.info(message);
        }
    }
}
