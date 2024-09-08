package com.emazon.transaction.domain.spi;

import com.emazon.transaction.domain.model.Supply;

public interface SupplyPersistencePort {
    void save(Supply supply);
}