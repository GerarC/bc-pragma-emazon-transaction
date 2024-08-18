package com.emazon.transaction.adapters.driven.feigns.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductRequest {
    private Long quantity;
}
