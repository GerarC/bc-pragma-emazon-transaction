package com.emazon.transaction.adapters.driven.feigns.client;

import com.emazon.transaction.adapters.driven.feigns.dto.response.UserResponse;
import com.emazon.transaction.configuration.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "USER-MICROSERVICE", url = "${emazon.user.base-url}" + "/v1/user", configuration = FeignClientConfiguration.class)
public interface UserFeign {
    @GetMapping("/token")
    UserResponse getUserByToken();
}
