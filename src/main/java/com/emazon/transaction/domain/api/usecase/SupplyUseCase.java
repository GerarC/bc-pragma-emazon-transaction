package com.emazon.transaction.domain.api.usecase;

import com.emazon.transaction.domain.api.SupplyServicePort;
import com.emazon.transaction.domain.model.Supply;
import com.emazon.transaction.domain.spi.ProductPersistencePort;
import com.emazon.transaction.domain.spi.SupplyPersistencePort;

public class SupplyUseCase implements SupplyServicePort {
    private final SupplyPersistencePort supplyPersistencePort;
    private final ProductPersistencePort productPersistencePort;

    public SupplyUseCase(SupplyPersistencePort supplyPersistencePort, ProductPersistencePort productPersistencePort) {
        this.supplyPersistencePort = supplyPersistencePort;
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public void save(Supply supply) {
        productPersistencePort.incrementQuantity(supply.getProductId(), supply.getQuantity());
        supplyPersistencePort.save(supply);
    }
}
