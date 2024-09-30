package com.emazon.transaction.adapters.driven.jpa.adapter;

import com.emazon.transaction.adapters.driven.jpa.entity.SaleEntity;
import com.emazon.transaction.adapters.driven.jpa.mapper.SaleEntityMapper;
import com.emazon.transaction.adapters.driven.jpa.persistence.SaleRepository;
import com.emazon.transaction.domain.model.Sale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SaleJpaAdapterTest {

    @Mock
    private SaleRepository saleRepository;

    @Mock
    private SaleEntityMapper saleEntityMapper;

    @InjectMocks
    private SaleJpaAdapter saleJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveSales() {
        List<Sale> sales = List.of(new Sale(), new Sale());
        List<SaleEntity> saleEntities = List.of(new SaleEntity(), new SaleEntity());
        when(saleEntityMapper.toEntities(sales)).thenReturn(saleEntities);
        when(saleRepository.saveAll(saleEntities)).thenReturn(saleEntities);
        saleJpaAdapter.saveSales(sales);
        verify(saleRepository).saveAll(saleEntities);
    }
}