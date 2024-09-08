package com.emazon.transaction.adapters.driven.jpa.adapter;

import com.emazon.transaction.adapters.driven.jpa.entity.SupplyEntity;
import com.emazon.transaction.adapters.driven.jpa.mapper.SupplyEntityMapper;
import com.emazon.transaction.adapters.driven.jpa.persistence.SupplyRepository;
import com.emazon.transaction.domain.model.Supply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SupplyJpaAdapterTest {

    @Mock
    private SupplyRepository supplyRepository;

    @Mock
    private SupplyEntityMapper supplyEntityMapper;

    @InjectMocks
    private SupplyJpaAdapter supplyJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        Supply supply = new Supply();
        SupplyEntity supplyEntity = new SupplyEntity();
        when(supplyEntityMapper.toEntity(supply)).thenReturn(supplyEntity);
        when(supplyRepository.save(any())).thenReturn(supplyEntity);
        supplyJpaAdapter.save(supply);
        verify(supplyRepository).save(any());
    }
}