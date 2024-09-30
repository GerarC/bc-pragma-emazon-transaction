package com.emazon.transaction.adapters.driven.jpa.mapper;

import com.emazon.transaction.adapters.driven.jpa.entity.SaleEntity;
import com.emazon.transaction.domain.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SaleEntityMapper {
    SaleEntity toEntity(Sale supply);
    List<SaleEntity> toEntities(List<Sale> sales);
    Sale toDomain(SaleEntity supplyEntity);
    List<Sale> toDomains(List<SaleEntity> supplyEntities);
}
