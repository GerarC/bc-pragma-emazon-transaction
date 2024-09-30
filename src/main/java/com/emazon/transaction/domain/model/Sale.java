package com.emazon.transaction.domain.model;

import java.time.LocalDateTime;

public class Sale {
    private Long id;
    private Long productId;
    private Long quantity;
    private String userId;
    private LocalDateTime timestamp;

    public Sale(Long id, Long productId, Long quantity, String userId, LocalDateTime timestamp) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public Sale() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}