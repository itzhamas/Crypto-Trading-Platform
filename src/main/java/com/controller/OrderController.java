package com.controller;


import com.domain.OrderType;
import com.modal.Coin;
import com.modal.Order;
import com.modal.User;
import com.request.CreateOrderRequest;
import com.service.CoinService;
import com.service.OrderService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userSerivce;
    @Autowired
    private CoinService coinService;
//    @Autowired
//    private WalletTransactionService walletTransactionService;

    @PostMapping("/pay")
    public ResponseEntity<Order> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreateOrderRequest req
    ) throws Exception {
        User user =userSerivce.findUserProfileByJwt(jwt);
        Coin coin =coinService.findById(req.getCoinId());
        Order order= orderService.processorder(coin, req.getQuantity(),req.getOrderType(),user);

        return ResponseEntity.ok(order);
    }


    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrdersForUser(
            @RequestHeader("Authorization") String jwt,
            @RequestParam(required = false) OrderType order_type,
            @RequestParam(required = false) String asset_symbol
    ) throws Exception {
        Long userId = userSerivce.findUserProfileByJwt(jwt).getId();
        List<Order> userOrders =orderService.getAllOrdersOfUser(userId, order_type, asset_symbol);

        return ResponseEntity.ok(userOrders);

    }




}
