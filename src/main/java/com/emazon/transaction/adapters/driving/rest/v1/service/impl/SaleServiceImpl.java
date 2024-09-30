package com.emazon.transaction.adapters.driving.rest.v1.service.impl;

import com.emazon.transaction.adapters.driving.rest.v1.dto.request.SaleItemsRequest;
import com.emazon.transaction.adapters.driving.rest.v1.mapper.request.ItemRequestMapper;
import com.emazon.transaction.adapters.driving.rest.v1.service.SaleService;
import com.emazon.transaction.domain.api.SaleServicePort;
import com.emazon.transaction.domain.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleServicePort saleServicePort;
    private final ItemRequestMapper itemRequestMapper;

    @Override
    public void saveSale(SaleItemsRequest request) {
        List<Item> items = itemRequestMapper.toDomains(request.getItems());
        saleServicePort.saveSales(items);
    }
}
