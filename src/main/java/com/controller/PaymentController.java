package com.controller;


import com.domain.PaymentMethod;
import com.modal.PaymentOrder;
import com.modal.User;
import com.razorpay.RazorpayException;
import com.response.PaymentResponse;
import com.service.PaymentService;
import com.service.UserService;
import com.stripe.exception.StripeException;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;



    @PostMapping("/api/payment/{paymentMethod}/amount/{amount}")
    public ResponseEntity<PaymentResponse> paymentHandler(
            @PathVariable PaymentMethod paymentMethod,
            @PathVariable Long amount,
            @RequestHeader("Authorization") String jwt) throws
            Exception,
            RazorpayException,
            StripeException {
        User user= userService.findUserProfileByJwt(jwt);

        PaymentResponse paymentResponse;
        PaymentOrder order =paymentService.createOrder (user, amount, paymentMethod);
        if (paymentMethod.equals(PaymentMethod.RAZORPAY)) {
            paymentResponse=paymentService.createRazorpayPaymentLing(user, amount);
        }
        else{
            paymentResponse=paymentService.createStripePaymentLing(user, amount, order.getId()) ;
        }
        return new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
    }



}
