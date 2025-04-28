package com.hilpitome.b2cPaymentGatewayDemo.repository;

import com.hilpitome.b2cPaymentGatewayDemo.entity.PaymentRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentRequestLog, BigInteger> {

    @Query("SELECT p from payment_request_logs where p.sender = :senderNo")
    Optional<List<PaymentRequestLog>> getBySender(String senderNo);

    @Query("SELECT p from payment_request_logs where p.sender = :senderNo")
    Optional<List<PaymentRequestLog>> getBySenderAndReceiver(String senderNo);
}
