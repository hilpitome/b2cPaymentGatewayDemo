package com.hilpitome.b2cPaymentGatewayDemo.mapper;

import com.hilpitome.b2cPaymentGatewayDemo.dto.PaymentRequestDTO;
import com.hilpitome.b2cPaymentGatewayDemo.entity.PaymentRequestLog;
import org.mapstruct.factory.Mappers;

public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
    PaymentRequestLog toEntity(PaymentRequestDTO paymentRequestDTO);
    PaymentRequestDTO toDTO(PaymentRequestLog paymentRequestLog);
}
