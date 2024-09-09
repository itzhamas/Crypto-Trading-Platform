package com.service;

import com.domain.OrderType;
import com.modal.Coin;
import com.modal.Order;
import com.modal.OrderItem;
import com.modal.User;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createOrder (User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId) throws Exception;
    List<Order> getAllOrdersOfUser (Long userId, OrderType orderType, String assetSymbol);
    Order processorder (Coin coin, double quantity, OrderType orderType, User user) throws Exception;

}
