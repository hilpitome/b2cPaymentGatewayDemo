package com.hilpitome.b2cPaymentGatewayDemo.service.serviceImpl;

import com.hilpitome.b2cPaymentGatewayDemo.dto.ApiResponseDTO;
import com.hilpitome.b2cPaymentGatewayDemo.dto.PaymentRequestDTO;
import com.hilpitome.b2cPaymentGatewayDemo.dto.PaymentResponseDTO;
import com.hilpitome.b2cPaymentGatewayDemo.entity.PaymentRequestLog;
import com.hilpitome.b2cPaymentGatewayDemo.repository.PaymentRepository;
import com.hilpitome.b2cPaymentGatewayDemo.service.PaymentService;
import com.hilpitome.b2cPaymentGatewayDemo.service.SmsGatewayService;
import org.mapstruct.ap.shaded.freemarker.core.ReturnInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.net.http.HttpClient;

@Service
public class PaymentServiceImpl implements PaymentService {

    final PaymentRepository paymentRepository;
    final SmsGatewayService smsGatewayService;
    final B2CPaymentServiceImpl b2CPaymentService;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, SmsGatewayService smsGatewayService, B2CPaymentServiceImpl b2CPaymentService) {
        this.paymentRepository = paymentRepository;
        this.smsGatewayService = smsGatewayService;
        this.b2CPaymentService = b2CPaymentService;
    }

    @Override
    public ApiResponseDTO<PaymentResponseDTO<String>> makePayment(PaymentRequestLog paymentDetails) {
        PaymentRequestLog paymentRequestLog = paymentRepository.save(paymentDetails);

        smsGatewayService.sendMessage("Initiated payment of " + paymentRequestLog.getReceiver());
        b2CPaymentService.sendMoney(paymentRequestLog);

        if (paymentRequestLog.getId().compareTo(BigInteger.ZERO) > 0) {
            PaymentResponseDTO<String> response = new PaymentResponseDTO<String>("Initiated payment of " + paymentRequestLog.getAmount() + " to " + paymentRequestLog.getReceiver());

            return ApiResponseDTO.<PaymentResponseDTO<String>>builder()
                    .data(response)
                    .message("success")
                    .statusCode(HttpStatus.OK.value()).build();
        } else {
            return ApiResponseDTO.<PaymentResponseDTO<String>>builder().data(new PaymentResponseDTO<>("Failed to send " + paymentDetails.getAmount() + " to " + paymentDetails.getAmount())).message("Failure").statusCode(HttpStatus.OK.value()).build();
        }
    }
}
