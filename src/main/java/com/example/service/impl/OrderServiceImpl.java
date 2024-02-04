package com.example.service.impl;

import com.example.domain.Order;

import com.example.domain.Product;
import com.example.exception.NotEnoughQuantity;
import com.example.payload.OrderDto;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void createOrder(Long productId, OrderDto orderDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        int orderQuantity = orderDto.getQuantity();
        int productQuantity = product.getQuantity();

        if (orderQuantity > productQuantity) {
            throw new NotEnoughQuantity();
        }

        product.setQuantity(productQuantity - orderQuantity);
        productRepository.save(product);

        Order order = new Order();
        order.setProduct(product);
        order.setQuantity(orderQuantity);

        orderRepository.save(order);
    }
}