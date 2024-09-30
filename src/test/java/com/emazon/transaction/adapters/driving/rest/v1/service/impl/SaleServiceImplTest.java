package com.emazon.transaction.adapters.driving.rest.v1.service.impl;

import com.emazon.transaction.adapters.driving.rest.v1.dto.request.ItemRequest;
import com.emazon.transaction.adapters.driving.rest.v1.dto.request.SaleItemsRequest;
import com.emazon.transaction.adapters.driving.rest.v1.mapper.request.ItemRequestMapper;
import com.emazon.transaction.domain.api.SaleServicePort;
import com.emazon.transaction.domain.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SaleServiceImplTest {

    @Mock
    SaleServicePort saleServicePort;

    @Mock
    ItemRequestMapper itemRequestMapper;

    @InjectMocks
    SaleServiceImpl saleService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveSale() {
        // Arrange
        ItemRequest itemRequest1 = new ItemRequest(1L, 2);
        ItemRequest itemRequest2 = new ItemRequest(2L, 3);
        SaleItemsRequest request = new SaleItemsRequest(Arrays.asList(itemRequest1, itemRequest2));

        Item item1 = new Item(1L, 2);
        Item item2 = new Item(2L, 3);
        List<Item> items = Arrays.asList(item1, item2);

        when(itemRequestMapper.toDomains(request.getItems())).thenReturn(items);

        // Act
        saleService.saveSale(request);

        // Assert
        verify(itemRequestMapper).toDomains(request.getItems());
        verify(saleServicePort).saveSales(items);
    }
}