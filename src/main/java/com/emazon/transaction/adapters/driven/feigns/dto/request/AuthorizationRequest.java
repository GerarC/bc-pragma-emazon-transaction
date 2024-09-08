package com.emazon.transaction.adapters.driven.feigns.dto.request;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationRequest {
    private String token;
}
