package com.emazon.transaction.domain.spi;

import com.emazon.transaction.domain.model.Sale;

import java.util.List;

public interface SalePersistencePort {
    void saveSales(List<Sale> sales);
}
