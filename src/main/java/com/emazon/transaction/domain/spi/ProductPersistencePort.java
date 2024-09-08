package com.emazon.transaction.domain.spi;

public interface ProductPersistencePort {
    void incrementQuantity(Long productId, Long quantity);
}
