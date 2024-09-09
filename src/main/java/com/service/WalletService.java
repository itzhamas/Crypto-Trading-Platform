package com.service;

import com.modal.Order;
import com.modal.User;
import com.modal.Wallet;

public interface WalletService {


    Wallet getUserWallet(User user);



    Wallet addBalance(Wallet wallet, Long money);



    Wallet findWalletById(Long id) throws Exception;



    Wallet walletToWalletTransfer(User sender, Wallet receiverWallet, Long amount) throws Exception;


    Wallet payOrderPayment(Order order, User user) throws Exception;
}