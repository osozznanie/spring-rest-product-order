package com.example.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Long productId;
    private int quantity;

    public OrderDto(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
