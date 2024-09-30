package com.emazon.transaction.adapters.driving.rest.v1.controller;

import com.emazon.transaction.adapters.driving.rest.v1.dto.request.ItemRequest;
import com.emazon.transaction.adapters.driving.rest.v1.dto.request.SaleItemsRequest;
import com.emazon.transaction.adapters.driving.rest.v1.service.SaleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SaleController.class)
@AutoConfigureMockMvc
class SaleControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @MockBean
    private SaleService saleService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerSale() throws Exception {
        // Prepare mock sale request
        ItemRequest itemRequest = ItemRequest.builder()
                .productId(1L)
                .quantity(2)
                .build();

        SaleItemsRequest saleItemsRequest = SaleItemsRequest.builder()
                .items(List.of(itemRequest))
                .build();

        // Mock the service call
        doNothing().when(saleService).saveSale(any());

        // Perform the POST request
        this.mockMvc.perform(post("/v1/sales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saleItemsRequest)))
                .andExpect(status().isCreated());
    }
}