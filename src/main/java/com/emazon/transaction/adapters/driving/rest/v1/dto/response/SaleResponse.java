package com.emazon.transaction.adapters.driving.rest.v1.dto.response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleResponse {
    private Long id;
    private Long productId;
    private Long quantity;
}
