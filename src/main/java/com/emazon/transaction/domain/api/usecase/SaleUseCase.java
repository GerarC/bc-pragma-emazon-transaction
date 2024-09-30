package com.emazon.transaction.domain.api.usecase;

import com.emazon.transaction.domain.api.SaleServicePort;
import com.emazon.transaction.domain.exceptions.EntityNotFoundException;
import com.emazon.transaction.domain.model.Item;
import com.emazon.transaction.domain.model.Sale;
import com.emazon.transaction.domain.spi.SalePersistencePort;
import com.emazon.transaction.domain.spi.UserPersistencePort;
import com.emazon.transaction.domain.spi.ProductPersistencePort;
import com.emazon.transaction.domain.utils.DomainConstants;

import java.time.LocalDateTime;
import java.util.List;

public class SaleUseCase implements SaleServicePort {
    private final SalePersistencePort salePersistencePort;
    private final UserPersistencePort userPersistencePort;
    private final ProductPersistencePort productPersistencePort;

    public SaleUseCase(SalePersistencePort salePersistencePort,
                       UserPersistencePort userPersistencePort,
                       ProductPersistencePort productPersistencePort) {
        this.salePersistencePort = salePersistencePort;
        this.userPersistencePort = userPersistencePort;
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public void saveSales(List<Item> items) {
        String userId = userPersistencePort.getIdFromCurrentUser();
        if (userId == null) throw new EntityNotFoundException(DomainConstants.NOT_CURRENT_USER_MESSAGE);
        List<Sale> sales = items.stream().map(item -> new Sale(
                null,
                item.getProductId(),
                item.getQuantity().longValue(),
                userId,
                LocalDateTime.now()
        )).toList();
        salePersistencePort.saveSales(sales);
        sales.forEach(sale -> productPersistencePort
                .decrementQuantity(sale.getProductId(), sale.getQuantity()));
    }
}
