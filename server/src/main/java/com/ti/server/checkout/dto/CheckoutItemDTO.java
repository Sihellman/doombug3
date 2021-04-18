package com.ti.server.checkout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CheckoutItemDTO {
    private String productName;
    private int  quantity;
    private double price;
    private long productId;
    private int userId;

    public CheckoutItemDTO() {}

    public CheckoutItemDTO(String productName, int quantity, double price, long productId, int userId) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
        this.userId = userId;
    }
}
