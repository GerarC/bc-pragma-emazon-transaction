package com.emazon.transaction.adapters.driving.rest.v1.dto.request;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItemsRequest {
    private List<ItemRequest> items;
}
