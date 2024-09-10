package com.emazon.transaction.adapters.driven.feigns.client;

import com.emazon.transaction.adapters.driven.feigns.dto.request.AuthorizationRequest;
import com.emazon.transaction.adapters.driven.feigns.dto.response.AuthorizationResponse;
import com.emazon.transaction.configuration.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER-MICROSERVICE", url = "${emazon.user.base-url}", configuration = FeignClientConfiguration.class)
public interface AuthorizationFeign {
    @PutMapping(value = "/auth/authorize", consumes = MediaType.APPLICATION_JSON_VALUE)
    AuthorizationResponse authorize(@RequestBody AuthorizationRequest authorizationRequest);
}
