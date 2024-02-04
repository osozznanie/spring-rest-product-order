package com.example.service;

import com.example.payload.OrderDto;

public interface OrderService {
    void createOrder(Long id, OrderDto orderDto);
}
