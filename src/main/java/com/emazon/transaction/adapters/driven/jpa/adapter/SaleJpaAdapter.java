package com.emazon.transaction.adapters.driven.jpa.adapter;

import com.emazon.transaction.adapters.driven.jpa.entity.SaleEntity;
import com.emazon.transaction.adapters.driven.jpa.mapper.SaleEntityMapper;
import com.emazon.transaction.adapters.driven.jpa.persistence.SaleRepository;
import com.emazon.transaction.domain.model.Sale;
import com.emazon.transaction.domain.spi.SalePersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class SaleJpaAdapter  implements SalePersistencePort {
    private final SaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    @Override
    public void saveSales(List<Sale> sales) {
        List<SaleEntity> entities = saleEntityMapper.toEntities(sales);
        saleRepository.saveAll(entities);
    }
}
