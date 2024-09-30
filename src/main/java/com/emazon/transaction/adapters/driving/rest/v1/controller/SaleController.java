package com.emazon.transaction.adapters.driving.rest.v1.controller;

import com.emazon.transaction.adapters.driving.rest.v1.dto.request.SaleItemsRequest;
import com.emazon.transaction.adapters.driving.rest.v1.dto.response.SaleResponse;
import com.emazon.transaction.adapters.driving.rest.v1.service.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/sales")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<List<SaleResponse>> registerSale(@RequestBody @Valid SaleItemsRequest request){
        saleService.saveSale(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
