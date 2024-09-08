package com.emazon.transaction.adapters.driving.rest.service.impl;

import com.emazon.transaction.adapters.driving.rest.dto.request.SupplyRequest;
import com.emazon.transaction.adapters.driving.rest.mapper.request.SupplyRequestMapper;
import com.emazon.transaction.adapters.driving.rest.service.SupplyService;
import com.emazon.transaction.domain.api.SupplyServicePort;
import com.emazon.transaction.domain.model.Supply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SupplyServiceImplTest {
    @Mock
    private SupplyRequestMapper supplyRequestMapper;

    @Mock
    private SupplyServicePort supplyServicePort;

    @InjectMocks
    private SupplyServiceImpl supplyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        Supply supply = new Supply();
        SupplyRequest supplyRequest = new SupplyRequest();
        when(supplyRequestMapper.toDomain(supplyRequest)).thenReturn(supply);
        doNothing().when(supplyServicePort).save(supply);
        supplyService.save(supplyRequest);
        verify(supplyServicePort).save(any());
    }
}