package com.emazon.transaction.adapters.driving.rest.v1.mapper.request;

import com.emazon.transaction.adapters.driving.rest.v1.dto.request.SupplyRequest;
import com.emazon.transaction.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyRequestMapper {
    Supply toDomain(SupplyRequest supplyRequest);
    List<Supply> toDomains(List<SupplyRequest> supplyRequests);
}
