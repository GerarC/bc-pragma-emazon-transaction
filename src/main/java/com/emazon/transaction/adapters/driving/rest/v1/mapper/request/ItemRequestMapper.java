package com.emazon.transaction.adapters.driving.rest.v1.mapper.request;

import com.emazon.transaction.adapters.driving.rest.v1.dto.request.ItemRequest;
import com.emazon.transaction.domain.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemRequestMapper {
    Item toDomain(ItemRequest itemRequest);
    List<Item> toDomains(List<ItemRequest> itemRequests);
}
