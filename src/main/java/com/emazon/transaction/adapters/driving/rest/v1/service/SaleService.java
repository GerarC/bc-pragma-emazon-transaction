package com.emazon.transaction.adapters.driving.rest.v1.service;

import com.emazon.transaction.adapters.driving.rest.v1.dto.request.SaleItemsRequest;

public interface SaleService {
    void saveSale(SaleItemsRequest request);
}
