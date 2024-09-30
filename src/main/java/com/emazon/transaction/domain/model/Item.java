package com.emazon.transaction.domain.model;

public class Item {
    Long productId;
    Integer quantity;

    public Item(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Item() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
