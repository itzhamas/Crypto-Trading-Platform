package com.repository;

import com.modal.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails,Long> {


    PaymentDetails findByUserId(Long userId);
}
