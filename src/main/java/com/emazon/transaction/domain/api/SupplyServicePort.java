package com.emazon.transaction.domain.api;

import com.emazon.transaction.domain.model.Supply;

public interface SupplyServicePort {
    void save(Supply supply);
}
