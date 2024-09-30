package com.emazon.transaction.adapters.driven.feigns.adapter;

import com.emazon.transaction.adapters.driven.feigns.client.ProductFeign;
import com.emazon.transaction.domain.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductFeignAdapterTest {

    @Mock
    private ProductFeign productFeign;

    @InjectMocks
    private ProductFeignAdapter productFeignAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void incrementQuantity() {
        Long id = 1L;
        Long quantity = 2L;
        doNothing().when(productFeign).addSupply(eq(id), any());
        productFeignAdapter.incrementQuantity(id, quantity);
        verify(productFeign).addSupply(eq(id), any());
    }

    @Test
    void incrementQuantity_EntityNotFoundException() {
        Long id = 1L;
        Long quantity = 2L;
        doThrow(EntityNotFoundException.class).when(productFeign).addSupply(eq(id), any());
        assertThrows(EntityNotFoundException.class, () -> productFeignAdapter.incrementQuantity(id, quantity));
    }

    @Test
    void decrementQuantity() {
        Long id = 1L;
        Long quantity = 2L;
        doNothing().when(productFeign).removeSupply(eq(id), any());
        productFeignAdapter.decrementQuantity(id, quantity);
        verify(productFeign).removeSupply(eq(id), any());
    }
}