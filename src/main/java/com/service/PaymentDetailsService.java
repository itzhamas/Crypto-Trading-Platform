package com.service;

import com.modal.PaymentDetails;
import com.modal.User;

public interface PaymentDetailsService {


    public PaymentDetails addPaymentDetails(String accountNumber,

                                            String accountHolderName,
                                            String ifsc,
                                            String bankName,
                                            User user);
    public PaymentDetails getUsersPaymentDetails (User user);
}
