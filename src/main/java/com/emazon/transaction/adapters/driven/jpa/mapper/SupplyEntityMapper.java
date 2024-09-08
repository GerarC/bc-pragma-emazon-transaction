package com.emazon.transaction.adapters.driven.jpa.mapper;

import com.emazon.transaction.adapters.driven.jpa.entity.SupplyEntity;
import com.emazon.transaction.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyEntityMapper {
    SupplyEntity toEntity(Supply supply);
    List<Supply> toEntities(List<SupplyEntity> supplyEntities);
    Supply toDomain(SupplyEntity supplyEntity);
    List<Supply> toDomains(List<SupplyEntity> supplyEntities);
}
