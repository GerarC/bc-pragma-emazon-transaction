package com.emazon.transaction.adapters.driving.rest.controller;

import com.emazon.transaction.adapters.driving.rest.dto.request.SupplyRequest;
import com.emazon.transaction.adapters.driving.rest.service.SupplyService;
import com.emazon.transaction.adapters.driving.rest.utils.JsonParser;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SupplyController.class)
@AutoConfigureMockMvc
class SupplyControllerTest {

    MockMvc mockMvc;
    private final WebApplicationContext webApplicationContext;


    @MockBean
    private SupplyService supplyService;

    @Autowired
    public SupplyControllerTest(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() throws Exception {
        SupplyRequest mockSupply = new SupplyRequest(1L, 1L);
        doNothing().when(supplyService).save(any());
        this.mockMvc.perform(post("/supply")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(JsonParser.toJson(mockSupply))).andExpect(status().isCreated());
    }
}