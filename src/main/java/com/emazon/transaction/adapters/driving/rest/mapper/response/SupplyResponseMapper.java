package com.emazon.transaction.adapters.driving.rest.mapper.response;

import com.emazon.transaction.adapters.driving.rest.dto.request.SupplyRequest;
import com.emazon.transaction.adapters.driving.rest.dto.response.SupplyResponse;
import com.emazon.transaction.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyResponseMapper {
    SupplyResponse toResponse(Supply supply);
    List<SupplyResponse> toResponses(List<Supply> supplies);
}
