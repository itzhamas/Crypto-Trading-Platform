package com.controller;


import com.modal.User;
import com.modal.Wallet;
import com.modal.WalletTransaction;
import com.modal.Withdrawal;
import com.service.UserService;
import com.service.WalletService;
import com.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;
    @Autowired
    private UserService userService;

    private WalletService walletService;
//    @Autowired
//    private WalletTransaction walletTransaction;


    @PostMapping("/api/withdrawal/{amount}")
    public ResponseEntity<?> withdrawalRequest(
            @PathVariable Long amount,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Wallet userWallet = walletService.getUserWallet(user);
        Withdrawal withdrawal = withdrawalService.requestyWithdrawal(amount, user);
        walletService.addBalance(userWallet, withdrawal.getAmount());

        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }



    @PatchMapping("/api/admin/withdrawal/{id}/proceed/{accept}")
    public ResponseEntity<?> proceedWithdrawal (
            @PathVariable Long id,
            @PathVariable boolean accept,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user =userService.findUserProfileByJwt(jwt);
        Withdrawal withdrawal =withdrawalService.procedWithwithdrawal (id,accept);
        Wallet userWallet=walletService.getUserWallet(user);
        if(!accept){
            walletService.addBalance(userWallet, withdrawal.getAmount());
        }
        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }





}
