package com.emazon.transaction.adapters.driving.rest.dto.request;

import com.emazon.transaction.domain.utils.DomainConstants;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyRequest {
    @NotNull(message = DomainConstants.PRODUCT_ID_FIELD_NULL_MESSAGE)
    private Long productId;

    @NotNull(message = DomainConstants.QUANTITY_FIELD_NULL_MESSAGE)
    private Long quantity;
}
