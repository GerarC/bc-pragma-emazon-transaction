package com.emazon.transaction.adapters.driven.jpa.adapter;

import com.emazon.transaction.adapters.driven.jpa.mapper.SupplyEntityMapper;
import com.emazon.transaction.adapters.driven.jpa.persistence.SupplyRepository;
import com.emazon.transaction.domain.model.Supply;
import com.emazon.transaction.domain.spi.SupplyPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyJpaAdapter implements SupplyPersistencePort {

    private final SupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;

    @Override
    public void save(Supply supply) {
        supplyRepository.save(supplyEntityMapper.toEntity(supply));
    }
}
