package com.hilpitome.b2cPaymentGatewayDemo.controller;

import com.hilpitome.b2cPaymentGatewayDemo.dto.ApiRequestDTO;
import com.hilpitome.b2cPaymentGatewayDemo.dto.ApiResponseDTO;
import com.hilpitome.b2cPaymentGatewayDemo.dto.PaymentRequestDTO;
import com.hilpitome.b2cPaymentGatewayDemo.dto.PaymentResponseDTO;
import com.hilpitome.b2cPaymentGatewayDemo.mapper.PaymentMapper;
import com.hilpitome.b2cPaymentGatewayDemo.service.PaymentService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/payments/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("send-money")
    public ResponseEntity<ApiResponseDTO<PaymentResponseDTO<String>>> sendMoney(@RequestBody ApiRequestDTO<PaymentRequestDTO> paymentRequest) {
        log.info("received payment request for {}", paymentRequest.getData());
        ApiResponseDTO<PaymentResponseDTO<String>> response = paymentService.makePayment(PaymentMapper.INSTANCE.toEntity(paymentRequest.getData()));

        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("check-payment/{senderNo}")
    public ResponseEntity<ApiResponseDTO<String>> checkBySenderNo(@PathVariable String sendoNo) {
        return null;
    }

    @GetMapping("check-payment/{senderNo}/{receiverNo}")
    public ResponseEntity<ApiResponseDTO<String>> checkBySenderAndReceiver(@PathVariable String sendoNo, @PathVariable String receiverNo) {
        return null;
    }

    @GetMapping("payment/callback")
    public ResponseEntity<ApiResponseDTO<String>> paymentGatWayCallBack(@PathVariable String sendoNo, @PathVariable String receiverNo) {
        return null;
    }


}
