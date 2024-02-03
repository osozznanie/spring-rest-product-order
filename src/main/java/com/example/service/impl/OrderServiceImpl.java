package com.example.service.impl;

import com.example.domain.Order;
import com.example.domain.Product;
import com.example.exception.NotEnoughQuantity;
import com.example.payload.OrderDto;
import com.example.payload.ProductDto;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final ProductService productService;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(ProductService productService, OrderRepository orderRepository) {
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        ProductDto updatedProductDto = productService.updateProductQuantity(orderDto.getProductId(), orderDto.getQuantity());

        Order order = convertToEntity(orderDto, updatedProductDto);
        Order savedOrder = orderRepository.save(order);

        return convertToDto(savedOrder);
    }


    private OrderDto convertToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .productId(order.getProduct().getId())
                .quantity(order.getQuantity())
                .build();
    }

    private Order convertToEntity(OrderDto orderDto, ProductDto productDto) {
        Order order = new Order();
        Product product = productService.convertToEntity(productDto);
        order.setProduct(product);
        order.setQuantity(orderDto.getQuantity());
        return order;
    }
}