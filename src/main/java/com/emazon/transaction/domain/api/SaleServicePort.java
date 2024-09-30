package com.emazon.transaction.domain.api;

import com.emazon.transaction.domain.model.Item;

import java.util.List;

public interface SaleServicePort {
    void saveSales(List<Item> items);
}
