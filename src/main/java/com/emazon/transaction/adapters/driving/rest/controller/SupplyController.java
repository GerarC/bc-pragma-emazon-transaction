package com.emazon.transaction.adapters.driving.rest.controller;

import com.emazon.transaction.adapters.driving.rest.dto.request.SupplyRequest;
import com.emazon.transaction.adapters.driving.rest.dto.response.SupplyResponse;
import com.emazon.transaction.adapters.driving.rest.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class SupplyController {
    private final SupplyService supplyService;

    @PostMapping
    ResponseEntity<SupplyResponse> save(@RequestBody SupplyRequest supplyRequest) {
        supplyService.save(supplyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
