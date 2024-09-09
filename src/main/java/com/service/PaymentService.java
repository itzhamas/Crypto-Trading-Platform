package com.service;

import com.domain.PaymentMethod;
import com.modal.PaymentOrder;
import com.modal.User;
import com.razorpay.RazorpayException;
import com.response.PaymentResponse;
import com.stripe.exception.StripeException;

public interface PaymentService {

    PaymentOrder createOrder (User user, Long amount,
                            PaymentMethod paymentMethod);
    PaymentOrder getPaymentOrderById(Long id) throws Exception;
    Boolean ProccedPaymentOrder (PaymentOrder paymentOrder, String paymentId) throws RazorpayException;

    PaymentResponse createRazorpayPaymentLing (User user, Long amount) throws RazorpayException;

    PaymentResponse createStripePaymentLing (User user, Long amount,Long orderId) throws StripeException;



}
