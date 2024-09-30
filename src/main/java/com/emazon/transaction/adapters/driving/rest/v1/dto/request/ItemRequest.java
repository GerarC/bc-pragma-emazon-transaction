package com.emazon.transaction.adapters.driving.rest.v1.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemRequest {
    Long productId;
    Integer quantity;
}
