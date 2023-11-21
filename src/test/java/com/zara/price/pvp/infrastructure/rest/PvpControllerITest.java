package com.zara.price.pvp.infrastructure.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PvpControllerITest {

    private static final String url = "/brands/1/products/35455/pvp";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_priceList1_when_2020_06_14_10_00_00() throws Exception {

        mockMvc.perform(get(url).queryParam("date", "2020-06-14T10:00:00Z"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startAt").value("2020-06-14T00:00:00Z"))
                .andExpect(jsonPath("$.endAt").value("2020-12-31T23:59:59Z"))
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    void should_return_priceList2_when_2020_06_14_16_00_00() throws Exception {

        mockMvc.perform(get(url).queryParam("date", "2020-06-14T16:00:00Z"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.startAt").value("2020-06-14T15:00:00Z"))
                .andExpect(jsonPath("$.endAt").value("2020-06-14T18:30:00Z"))
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    void should_return_priceList1_when_2020_06_14_21_00_00() throws Exception {

        mockMvc.perform(get(url).queryParam("date", "2020-06-14T21:00:00Z"))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startAt").value("2020-06-14T00:00:00Z"))
                .andExpect(jsonPath("$.endAt").value("2020-12-31T23:59:59Z"))
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    void should_return_priceList3_when_2020_06_15_10_00_00() throws Exception {

        mockMvc.perform(get(url).queryParam("date", "2020-06-15T10:00:00Z"))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.startAt").value("2020-06-15T00:00:00Z"))
                .andExpect(jsonPath("$.endAt").value("2020-06-15T11:00:00Z"))
                .andExpect(jsonPath("$.price").value(30.50))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    void should_return_priceList4_when_2020_06_16_21_00_00() throws Exception {

        mockMvc.perform(get(url).queryParam("date", "2020-06-16T21:00:00Z"))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.startAt").value("2020-06-15T16:00:00Z"))
                .andExpect(jsonPath("$.endAt").value("2020-12-31T23:59:59Z"))
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }
}