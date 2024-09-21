package com.emazon.transaction.adapters.driving.rest.controller;

import com.emazon.transaction.adapters.driving.rest.dto.request.SupplyRequest;
import com.emazon.transaction.adapters.driving.rest.dto.response.SupplyResponse;
import com.emazon.transaction.adapters.driving.rest.service.SupplyService;
import com.emazon.transaction.adapters.driving.rest.utils.RestConstants;
import com.emazon.transaction.configuration.advice.responses.ExceptionResponse;
import com.emazon.transaction.configuration.advice.responses.ValidationExceptionResponse;
import com.emazon.transaction.domain.utils.TokenContainer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class SupplyController {
    private final SupplyService supplyService;

    @Operation(summary = RestConstants.SWAGGER_ADD_SUPPLY_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = RestConstants.CODE_CREATED, description = RestConstants.SWAGGER_ADD_SUPPLY_RESPONSE, content = @Content(schema = @Schema(implementation = SupplyResponse.class))),
            @ApiResponse(responseCode = RestConstants.CODE_BAD_REQUEST, description = RestConstants.SWAGGER_VALIDATIONS_DONT_PASS, content = @Content(schema = @Schema(implementation = ValidationExceptionResponse.class))),
            @ApiResponse(responseCode = RestConstants.CODE_NOT_FOUND, description = RestConstants.SWAGGER_ADD_SUPPLY_PRODUCT_NOT_FOUND, content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
    })
    @PostMapping
    ResponseEntity<SupplyResponse> save(
            @RequestHeader("Authorization") String token,
            @RequestBody @Valid SupplyRequest supplyRequest) {
        TokenContainer.setToken(token);
        supplyService.save(supplyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
