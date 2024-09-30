package com.emazon.transaction.adapters.driven.feigns.adapter;

import com.emazon.transaction.adapters.driven.feigns.client.ProductFeign;
import com.emazon.transaction.adapters.driven.feigns.dto.request.ProductRequest;
import com.emazon.transaction.domain.exceptions.EntityNotFoundException;
import com.emazon.transaction.domain.spi.ProductPersistencePort;
import com.emazon.transaction.domain.utils.DomainConstants;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFeignAdapter implements ProductPersistencePort {
    private final ProductFeign productFeign;

    @Override
    public void incrementQuantity(Long productId, Long quantity) {
        ProductRequest productRequest = new ProductRequest(quantity);
        try{
            productFeign.addSupply(productId, productRequest);
        } catch (FeignException.NotFound e) {
            throw new EntityNotFoundException(String.format(DomainConstants.PRODUCT_NOT_FOUND_MESSAGE, productId));
        }
    }

    @Override
    public void decrementQuantity(Long productId, Long quantity) {
        ProductRequest productRequest = new ProductRequest(quantity);
        try{
            productFeign.removeSupply(productId, productRequest);
        } catch (FeignException.NotFound e) {
            throw new EntityNotFoundException(String.format(DomainConstants.PRODUCT_NOT_FOUND_MESSAGE, productId));
        }
    }
}
