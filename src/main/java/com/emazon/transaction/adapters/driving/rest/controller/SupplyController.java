package com.emazon.transaction.adapters.driving.rest.controller;

import com.emazon.transaction.adapters.driving.rest.dto.request.SupplyRequest;
import com.emazon.transaction.adapters.driving.rest.dto.response.SupplyResponse;
import com.emazon.transaction.adapters.driving.rest.service.SupplyService;
import com.emazon.transaction.configuration.advice.responses.ExceptionResponse;
import com.emazon.transaction.configuration.advice.responses.ValidationExceptionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    @Operation(summary = "add a new supply")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "supply has been saved correctly", content = @Content(schema = @Schema(implementation = SupplyResponse.class))),
            @ApiResponse(responseCode = "400", description = "Any validation didn't pass", content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "Product with the given Id not found", content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
    })
    @PostMapping
    ResponseEntity<SupplyResponse> save(@RequestBody @Valid SupplyRequest supplyRequest) {
        supplyService.save(supplyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
