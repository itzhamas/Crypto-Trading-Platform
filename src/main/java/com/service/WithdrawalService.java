package com.service;

import com.modal.User;
import com.modal.Withdrawal;

import java.util.List;

public interface WithdrawalService {
    Withdrawal requestyWithdrawal (Long amount, User user);

    Withdrawal procedWithwithdrawal (Long withdrawalId, boolean accept) throws Exception;

    List<Withdrawal> getUsersWithdrawalHistory (User user);
    List<Withdrawal> getAllWithdrawalRequest();



}
