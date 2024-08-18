package com.emazon.transaction.adapters.driving.rest.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyRequest {
    private Long productId;
    private Long quantity;
}
