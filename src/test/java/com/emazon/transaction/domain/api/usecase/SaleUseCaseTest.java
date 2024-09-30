package com.emazon.transaction.domain.api.usecase;

import com.emazon.transaction.domain.exceptions.EntityNotFoundException;
import com.emazon.transaction.domain.model.Item;
import com.emazon.transaction.domain.spi.ProductPersistencePort;
import com.emazon.transaction.domain.spi.SalePersistencePort;
import com.emazon.transaction.domain.spi.UserPersistencePort;
import com.emazon.transaction.domain.utils.DomainConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

class SaleUseCaseTest {

    @Mock
    SalePersistencePort salePersistencePort;

    @Mock
    UserPersistencePort userPersistencePort;

    @Mock
    ProductPersistencePort productPersistencePort;

    @InjectMocks
    SaleUseCase saleUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveSales_success() {
        // Arrange
        String userId = "testUserId";
        when(userPersistencePort.getIdFromCurrentUser()).thenReturn(userId);

        Item item1 = new Item(1L, 2);
        Item item2 = new Item(2L, 3);
        List<Item> items = Arrays.asList(item1, item2);

        // Act
        saleUseCase.saveSales(items);

        // Assert
        verify(salePersistencePort).saveSales(argThat(sales ->
                sales.size() == 2 &&
                        sales.get(0).getProductId().equals(item1.getProductId()) &&
                        sales.get(0).getQuantity().equals(item1.getQuantity().longValue()) &&
                        sales.get(1).getProductId().equals(item2.getProductId()) &&
                        sales.get(1).getQuantity().equals(item2.getQuantity().longValue())
        ));
        verify(productPersistencePort).decrementQuantity(item1.getProductId(), item1.getQuantity().longValue());
        verify(productPersistencePort).decrementQuantity(item2.getProductId(), item2.getQuantity().longValue());
    }

    @Test
    void saveSales_userNotFound() {
        // Arrange
        when(userPersistencePort.getIdFromCurrentUser()).thenReturn(null);

        Item item1 = new Item(1L, 2);
        List<Item> items = List.of(item1);

        // Act & Assert
        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            saleUseCase.saveSales(items);
        });

        assertEquals(DomainConstants.NOT_CURRENT_USER_MESSAGE, exception.getMessage());
        verify(salePersistencePort, never()).saveSales(any());
        verify(productPersistencePort, never()).decrementQuantity(any(), anyLong());
    }
}
