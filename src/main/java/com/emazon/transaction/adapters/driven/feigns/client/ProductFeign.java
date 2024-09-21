package com.emazon.transaction.adapters.driven.feigns.client;

import com.emazon.transaction.adapters.driven.feigns.dto.request.ProductRequest;
import com.emazon.transaction.configuration.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "STOCK-MICROSERVICE", url = "${emazon.stock.base-url}", configuration = FeignClientConfiguration.class)
public interface ProductFeign {
    @PutMapping(value = "/products/{id}/add-supply", produces = MediaType.APPLICATION_JSON_VALUE)
    void addSupply(@PathVariable Long id, @RequestBody ProductRequest productRequest);
}
