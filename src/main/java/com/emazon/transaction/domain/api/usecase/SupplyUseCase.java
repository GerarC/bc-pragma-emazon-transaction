package com.emazon.transaction.domain.api.usecase;

import com.emazon.transaction.domain.api.SupplyServicePort;
import com.emazon.transaction.domain.exceptions.EntityNotFoundException;
import com.emazon.transaction.domain.model.Supply;
import com.emazon.transaction.domain.spi.ProductPersistencePort;
import com.emazon.transaction.domain.spi.SupplyPersistencePort;
import com.emazon.transaction.domain.spi.UserPersistencePort;
import com.emazon.transaction.domain.utils.DomainConstants;

import java.time.LocalDateTime;

public class SupplyUseCase implements SupplyServicePort {
    private final SupplyPersistencePort supplyPersistencePort;
    private final ProductPersistencePort productPersistencePort;
    private final UserPersistencePort userPersistencePort;

    public SupplyUseCase(SupplyPersistencePort supplyPersistencePort, ProductPersistencePort productPersistencePort, UserPersistencePort userPersistencePort) {
        this.supplyPersistencePort = supplyPersistencePort;
        this.productPersistencePort = productPersistencePort;
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void save(Supply supply) {
        String userId = userPersistencePort.getIdFromCurrentUser();
        if (userId == null) throw new EntityNotFoundException(DomainConstants.NOT_CURRENT_USER_MESSAGE);
        productPersistencePort.incrementQuantity(supply.getProductId(), supply.getQuantity());
        supply.setUserId(userId);
        supply.setTimestamp(LocalDateTime.now());
        supplyPersistencePort.save(supply);
    }
}
