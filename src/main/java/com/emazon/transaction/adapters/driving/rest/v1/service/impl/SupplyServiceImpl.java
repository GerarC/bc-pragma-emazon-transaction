package com.emazon.transaction.adapters.driving.rest.v1.service.impl;

import com.emazon.transaction.adapters.driving.rest.v1.dto.request.SupplyRequest;
import com.emazon.transaction.adapters.driving.rest.v1.mapper.request.SupplyRequestMapper;
import com.emazon.transaction.adapters.driving.rest.v1.service.SupplyService;
import com.emazon.transaction.domain.api.SupplyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl implements SupplyService {
    private final SupplyServicePort supplyServicePort;
    private final SupplyRequestMapper supplyRequestMapper;

    @Override
    public void save(SupplyRequest supplyRequest) {
        supplyServicePort.save(supplyRequestMapper.toDomain(supplyRequest));
    }
}
