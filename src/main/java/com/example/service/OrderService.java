package com.example.service;

import com.example.payload.OrderDto;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
}
